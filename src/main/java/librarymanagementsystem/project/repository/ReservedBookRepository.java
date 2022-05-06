package librarymanagementsystem.project.repository;

import java.sql.*;
import java.util.*;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.DBConnection;

public class ReservedBookRepository {
	public void makeReservation(int bookid, String submissiondate, int userid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO reservation VALUES("+bookid+", " + userid + ",'"+submissiondate+"')");
	}
	public List<ReservedBookList> getReservedBookList() throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM reserved_book_list;");
		List<ReservedBookList> reservedbooklists = new ArrayList<>(); 
		while(rs.next())
		{
			ReservedBookList resevedbooklist = new ReservedBookList(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			reservedbooklists.add(resevedbooklist);
		}
		return reservedbooklists;
	}
}
