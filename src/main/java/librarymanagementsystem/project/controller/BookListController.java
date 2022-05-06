package librarymanagementsystem.project.controller;
import java.sql.*;
import java.util.List;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.view.*;

import librarymanagementsystem.project.repository.*;
public class BookListController {
	BookListRepository booklistrepository = new BookListRepository();
	AuthorRepository authorrepository = new AuthorRepository();
	MainView mainview = new MainView();
	public void addBook(String booktitle, int publicationyear, int copies, int categoryid, String currentauthorfirstname, String currentauthorlastname) throws Exception
	{
		int bookid = 0;
		int authorid = getAuthorId(currentauthorfirstname, currentauthorlastname);
		if(authorid != 0)
		{
			booklistrepository.addBook(booktitle, publicationyear, copies);
			bookid = booklistrepository.getRecentBookId();
			booklistrepository.insertBookCategory(bookid, categoryid);
			booklistrepository.insertBookAuthor(bookid, authorid);
			System.out.println("\n Book Added !!! \n");
			mainview.getStaffViewBookOptions();
		}
		booklistrepository.addBook(booktitle, publicationyear, copies);
		bookid = booklistrepository.getRecentBookId();
		booklistrepository.insertBookCategory(bookid, categoryid);
		authorrepository.insertNewAuthor(currentauthorfirstname, currentauthorlastname);
		authorid = getAuthorId(currentauthorfirstname, currentauthorlastname);
		authorrepository.insertBookAuthor(bookid, authorid);	
		System.out.println("\n Book Added !!! \n");
	}
	
	public void deleteBook(int bookid) throws SQLException
	{
		BookListRepository booklistrepository = new BookListRepository();
		booklistrepository.deleteBook(bookid);
	}
	public int getAuthorId(String firstname, String lastname) throws SQLException
	{
		AuthorRepository authorrepository = new AuthorRepository();
		int authorid = authorrepository.getAuthorId(firstname, lastname);
		return authorid;
	}

	public void editBookDetails(int bookid, String booktitle, int publicationyear, int copies, int categoryid, String currentauthorfirstname, String currentauthorlastname) throws SQLException
	{
		booklistrepository.editBookInfo(bookid, booktitle, publicationyear, copies);
		booklistrepository.editBookCategoryInfo(bookid, categoryid);
		int authorid = authorrepository.getAuthorId(currentauthorfirstname, currentauthorlastname);
		booklistrepository.editBookAuthorInfo(bookid, authorid);
	}
}
