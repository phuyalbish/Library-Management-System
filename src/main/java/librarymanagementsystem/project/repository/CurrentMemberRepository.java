package librarymanagementsystem.project.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import librarymanagementsystem.project.DBConnection;
import librarymanagementsystem.project.model.CurrentMember;

public class CurrentMemberRepository {
	public void setCurrentMember(int userid) throws SQLException
	{

		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		statement.executeUpdate("UPDATE member_login SET user_id = "+userid+"");
	}
	public CurrentMember getCurrentMember() throws SQLException
	{

		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT user_id FROM member_login;");
		rs.next();
		CurrentMember currentmember = new CurrentMember(rs.getInt(1));
        return currentmember;
	}
	
}