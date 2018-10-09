import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName(Constants.JDBC_DRIVER);
		
		final int AUTHOR_ID = 3;

		try (Connection connection 
				= DriverManager.getConnection(Constants.BASE_URL, Constants.USER_NAME, Constants.PASSWORD);
				PreparedStatement statement = connection.prepareStatement(Constants.GET_BOOKS_BY_AUTHOR)) {

			statement.setInt(Constants.AUTHOR_ID_INDEX, AUTHOR_ID);

			try (ResultSet resultSet = statement.executeQuery()) {

				while (resultSet.next()) {
					String title = resultSet.getString(Constants.TITLE_INDEX);
					int pageCount = resultSet.getInt(Constants.PAGE_INDEX);
					System.out.println(title + Constants.DELIMITER + pageCount + Constants.PAGES_WORD);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
