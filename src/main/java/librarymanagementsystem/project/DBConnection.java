package librarymanagementsystem.project;
import java.sql.*;

public class DBConnection {
		
		static Connection connection;
		public static Connection getConn() throws SQLException
		{
			if(connection == null)
				connection = DriverManager.getConnection("jdbc:mysql://sql6.freesqldatabase.com:3306/sql6436752","sql6436752","a7bfimb17U");
			return connection;
		}
}
