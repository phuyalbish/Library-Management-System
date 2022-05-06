package librarymanagementsystem.project.view;

import java.util.*;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.repository.*;

import java.sql.*;

public class BookListView {
	BookListRepository booklistrepository = new BookListRepository();
	
	
	//POV: member
	public void displayAllBookList() throws SQLException
	{
		List<BookList> booklists = booklistrepository.getAllBookList();

    	System.out.println("\nDisplaying Book Lists...");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringBorrower());
		}
	}
	
	public void displayBookListByBookName(String booktitle) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByBookName(booktitle);
		System.out.println("\nDisplaying Book Lists Titled '" + booktitle + "'");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringBorrower());
		}
	}
	
	public void displayBookListByAuthorName(String firstname, String lastname) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByAuthorName(firstname, lastname);
		System.out.println("\nDisplaying Book Lists From Author '" + firstname + " " + lastname + "';");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringBorrower());
		}
	}
	
	public void displayBookListByYear(int year) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByYear(year);
		System.out.println("\nDisplaying Book Lists By Publication Year '" + year + "'");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringBorrower());
		}
	}	
	
	//POV: staff
	public void displayAllBookListS() throws SQLException
	{
		List<BookList> booklists = booklistrepository.getAllBookList();

    	System.out.println("\nDisplaying Book Lists...");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringLibrarian());
		}
	}
	
	public void displayBookListByBookNameS(String booktitle) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByBookName(booktitle);
		System.out.println("\nDisplaying Book Lists Titled '" + booktitle + "'");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringLibrarian());
		}
	}
	
	public void displayBookListByAuthorNameS(String firstname, String lastname) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByAuthorName(firstname, lastname);
		System.out.println("\nDisplaying Book Lists From Author '" + firstname + " " + lastname + "';");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringLibrarian());
		}
	}
	
	public void displayBookListByYearS(int year) throws SQLException
	{
		List<BookList> booklists = booklistrepository.getBookListByYear(year);
		System.out.println("\nDisplaying Book Lists By Publication Year '" + year + "'");
		for(BookList booklist: booklists)
		{
			System.out.println();
			System.out.println(booklist.toStringLibrarian());
		}
	}	
}
