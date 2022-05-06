package librarymanagementsystem.project.repository;

import java.sql.*;
import java.util.*;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.DBConnection;

public class ReturnBookRepository {
	public void returnBook(int borrowedbookid, int bookid, int borrowerid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO returned_book(BOOK_ID, BORROWER_ID, RETURNED_DATE) VALUES("+bookid+","+borrowerid+",now());");
		statement.executeUpdate("DELETE FROM borrowed_book WHERE ID = "+borrowedbookid+";");
	}
	public List<ReturnedBookList> displayReturnedBooks() throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM returned_book_list;");
		List<ReturnedBookList> returnedbooklists = new ArrayList<>();
		while(rs.next())
		{
			ReturnedBookList returnedbooklist = new ReturnedBookList(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
			returnedbooklists.add(returnedbooklist);
		}
		return returnedbooklists;
	}
}
