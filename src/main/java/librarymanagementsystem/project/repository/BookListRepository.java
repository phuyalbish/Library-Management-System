package librarymanagementsystem.project.repository;
import java.sql.*;
import librarymanagementsystem.project.*;
import librarymanagementsystem.project.model.*;
import java.util.List;
import java.util.ArrayList;

public class BookListRepository { 
	public void inc_dec_AvailableBook(int bookid, int availablebook) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE book_list SET AVAILABLE_BOOKS = "+ availablebook +" WHERE BOOK_ID = "+ bookid +";");

	}
	public List<BookList> getAllBookList() throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
    	ResultSet rs = statement.executeQuery("SELECT * FROM book_list;");
    	List<BookList> booklists = new ArrayList<>();
    	while(rs.next())
		{
			BookList booklist = new BookList(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			booklists.add(booklist);
		}
    	
    	return booklists;
	}
	public List<BookList> getBookListByBookName(String booktitle) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
    	ResultSet rs = statement.executeQuery("SELECT * FROM book_list WHERE BOOK_TITLE = '" + booktitle + "'");
    	List<BookList> booklists = new ArrayList<>();
    	while(rs.next())
		{
			BookList booklist = new BookList(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));

			booklists.add(booklist);
		}
    	
    	return booklists;
	}
	public List<BookList> getBookListByAuthorName(String firstname, String lastname) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
    	ResultSet rs = statement.executeQuery("SELECT * FROM book_list WHERE AUTHOR_FIRST_NAME = '" + firstname +"' && AUTHOR_LAST_NAME = '" + lastname + "';");
    	List<BookList> booklists = new ArrayList<>();
    	while(rs.next())
		{
			BookList booklist = new BookList(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));

			booklists.add(booklist);
		}
    	
    	return booklists;
	}
	public List<BookList> getBookListByYear(int year) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
    	ResultSet rs = statement.executeQuery("SELECT * FROM book_list WHERE PUBLICATION_YEAR = " + year + "");
    	List<BookList> booklists = new ArrayList<>();
    	while(rs.next())
		{
			BookList booklist = new BookList(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			booklists.add(booklist);
		}
    	
    	return booklists;
	}
	
	public void addBook(String booktitle, int publicationyear, int copies) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("INSERT INTO book(TITLE, PUBLICATION_YEAR, COPIES) VALUES('" + booktitle + "'," +  publicationyear + "," + copies + ");");	
 
	}
	public int getRecentBookId() throws SQLException
	{
		int bookid = 0;
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM book");
		while(rs.next()) {
			  if(rs.isLast()) {
			      // is last row in ResultSet
				  bookid = rs.getInt(1);
			  }
			}

		return bookid;
	}
	public void insertBookCategory(int bookid, int categoryid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO book_category VALUES(" + bookid + "," + categoryid +")");
	}
	public void insertBookAuthor(int bookid, int authorid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO book_author VALUES(" + bookid + "," +  authorid + ")");
	}
	public void deleteBook(int bookid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();

    	statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
    	statement.executeUpdate("DELETE FROM book WHERE ID = " + bookid + "");
    	statement.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");
	}
	public void editBookInfo(int bookid, String booktitle, int publicationyear, int copies) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();

		statement.executeUpdate("UPDATE book SET TITLE='" + booktitle + "', PUBLICATION_YEAR=" + publicationyear + ",COPIES=" + copies  + " WHERE ID = " + bookid + ";");
	}
	public void editBookCategoryInfo(int bookid, int categoryid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();

		statement.executeUpdate("UPDATE book_category SET CATEGORY_ID='" + categoryid + "' WHERE BOOK_ID = " + bookid + ";");
	}
	public void editBookAuthorInfo(int bookid, int authorid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();

		statement.executeUpdate("UPDATE book_author SET AUTHOR_ID='" + authorid + "' WHERE BOOK_ID = " + bookid + ";");
	}
}