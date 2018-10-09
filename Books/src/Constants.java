
public class Constants {

	public static final String BASE_URL = "jdbc:mysql://localhost:3306/book_base";
	public static final String USER_NAME = "user";
	public static final String PASSWORD = "dDnRw4nx9vuyr";

	public static final String GET_BOOKS_BY_AUTHOR = "SELECT title, page_count FROM  books "
			+ "JOIN authors_books ON authors_books.book_id = books.id WHERE authors_books.author_id = ?";
	public static final int AUTHOR_ID_INDEX = 1;
	public static final int TITLE_INDEX = 1;
	public static final int PAGE_INDEX = 2;

	public static final String DELIMITER = " - ";
	public static final String PAGES_WORD = " pages";

}
