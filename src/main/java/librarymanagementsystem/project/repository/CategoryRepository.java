package librarymanagementsystem.project.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import librarymanagementsystem.project.DBConnection;
import librarymanagementsystem.project.model.*;

public class CategoryRepository {
	public List<Category> getCategory() throws SQLException
	{ 
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		List<Category> categories = new ArrayList<>();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM category");
		while(rs.next())
		{
			Category category = new Category(rs.getInt(1), rs.getString(2));
			categories.add(category);
		}
		return categories;
	}
	public void insertCategory(String categoryname) throws SQLException
	{

		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("INSERT INTO category(NAME) VALUES('" + categoryname + "')");
	}
}
