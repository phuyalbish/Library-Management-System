package librarymanagementsystem.project.repository;

import java.sql.*;
import librarymanagementsystem.project.DBConnection;
import librarymanagementsystem.project.model.LogIn;
import java.util.List;
import java.util.ArrayList;
public class LogInRepository {
	public List<LogIn> memberLogIn() throws SQLException
	{
		Connection connection  = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM borrower;");
		List<LogIn> members = new ArrayList<>();
		while(rs.next())
		{
			LogIn member = new LogIn(rs.getInt(1), rs.getString(5));
			members.add(member);
		}
		return members;		
	}
	public List<LogIn> staffLogIn() throws SQLException
	{
		Connection connection  = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM librarian_login;");
		List<LogIn> members = new ArrayList<>();
		while(rs.next())
		{
			LogIn member = new LogIn(rs.getInt(1),rs.getString(2));
			members.add(member);
		}
		return members;	
	}
}
