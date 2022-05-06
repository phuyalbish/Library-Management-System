package librarymanagementsystem.project.controller;
import java.util.List;
import java.sql.*;
import librarymanagementsystem.project.repository.*;
import librarymanagementsystem.project.model.*;
public class CategoryController {
	CategoryRepository categoryrepository = new CategoryRepository();
	public void displayCategory() throws SQLException
	{
		List<Category> categories = categoryrepository.getCategory();
		
		System.out.println("\nDisplaying Category List \n");
		for(Category category:categories)
		{
			System.out.println(category.toString());
			System.out.println("");
		}
	}
	public void insertCategory(String categoryname) throws SQLException
	{
		int categoryid = getCategoryId(categoryname);
		if(categoryid != 0)
		{
			System.out.println("\n Category Already Exist !!!");
		}
		else
		{
			categoryrepository.insertCategory(categoryname);
		}
	}
	public int getCategoryId(String categoryname) throws SQLException
	{

		List<Category> categories = categoryrepository.getCategory();
		for(Category category:categories)
		{
			if(category.getCategoryName().equals(categoryname))
			{
				return category.getCategoryId();
			}
		}
		return 0;
	}
}
