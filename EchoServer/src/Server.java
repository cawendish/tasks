import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] arg) {
		final int PORT = 8020;
		try (ServerSocket socket = new ServerSocket(PORT)) {
			while (true) {
				Socket incoming = socket.accept();
				Runnable runnable = new ThreadedEchoHandler(incoming);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ThreadedEchoHandler implements Runnable {
	private static final String CHARSET_NAME = "UTF8";
	private static final String GO_TO_NEXT_LINE = "\n";
	private static final String EXIT_WORD = "exit";
	private Socket socket;

	public ThreadedEchoHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try (InputStreamReader inStream = new InputStreamReader(socket.getInputStream(), CHARSET_NAME);
				OutputStreamWriter outStream = new OutputStreamWriter(socket.getOutputStream(), CHARSET_NAME);
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true)) {
			boolean isExit = false;
			while (!isExit && in.hasNextLine()) {
				String line = in.nextLine();
				out.write(line + GO_TO_NEXT_LINE);
				if (EXIT_WORD.equals(line)) {
					isExit = true;
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}