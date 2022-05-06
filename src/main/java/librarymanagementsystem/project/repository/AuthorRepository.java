package librarymanagementsystem.project.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import librarymanagementsystem.project.DBConnection;
import librarymanagementsystem.project.model.*;

public class AuthorRepository {
	BookListRepository booklistrepository = new BookListRepository();
	public List<Author> getAllAuthor() throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM author");
		List<Author> authors = new ArrayList<>();
		while(rs.next())
		{
			Author author = new Author(rs.getInt(1), rs.getString(2), rs.getString(3));
			authors.add(author);
		}
		return authors;
	}
	public int getAuthorId(String authorfirstname, String authorlastname) throws SQLException
	{
		int authorid = 0;
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		List<Author> authors = getAllAuthor();
		for(Author author:authors)
		{
			if((author.getFirstName().equals(authorfirstname)) && (author.getLastName().equals(authorlastname)))
			{
				ResultSet rs = statement.executeQuery("SELECT ID FROM author WHERE FIRST_NAME = '" + authorfirstname + "' && LAST_NAME = '"+ authorlastname +"';");
				while(rs.next()) {
					  if(rs.isLast()) {
					      // is last row in ResultSet
							return rs.getInt(1);
					  }
					}
			}
		}

		return authorid;
	}
	public void insertNewAuthor(String authorfirstname, String authorlastname) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("INSERT INTO author(FIRST_NAME, LAST_NAME) VALUES('"+ authorfirstname +"', '" + authorlastname + "');");
	}
	public void insertBookAuthor(int bookid, int authorid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("INSERT INTO book_author VALUES(" + bookid + "," + authorid + ");");
	}
}
