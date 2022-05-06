package librarymanagementsystem.project.view;
import java.util.Scanner;
import java.sql.*;

import librarymanagementsystem.project.controller.*;

public class BorrowBookView {
	Scanner scanner = new Scanner(System.in);
	BookListView booklistview = new BookListView();
	
	public void searchBookList() throws Exception
	{
		char ans;
		do
		{
			System.out.println("\n######### Search Page #########");
			System.out.println("Search Book By: ");
			System.out.println("0) Go To Main Page");
			System.out.println("1) Book Title");
			System.out.println("2) Author Name");
			System.out.println("3) Publication Year");
			System.out.println("Enter Your Choice: ");
			int choice = scanner.nextInt();
			MainView mainview = new MainView();
			switch(choice)
			{
			case 0: 
				mainview.getBorrowerMainView();
			case 1:
				System.out.println("Enter Book Title");
				String booktitle = scanner.next();
				booktitle = booktitle.toUpperCase();
				booklistview.displayBookListByBookName(booktitle);
				break;
			case 2:
				System.out.println("Enter Author First Name: ");
				String firstname = scanner.next();
				System.out.println("Enter Author Last Name: ");
				String lastname = scanner.next();
				firstname = firstname.toUpperCase();
				lastname = lastname.toUpperCase();
				booklistview.displayBookListByAuthorName(firstname, lastname);
				break;
			case 3:
				System.out.println("Enter Year: ");
				int year = scanner.nextInt();
				booklistview.displayBookListByYear(year);
				break;
				
			default:
				System.out.println("Invalid Choice !!!");
				System.out.println("");
				searchBookList();
			}
			System.out.println("\nDo You Want To Search Again [Y/N]: ");
			ans = scanner.next().charAt(0);
		
		}while(ans == 'y' || ans == 'Y');
	}
	public void searchBookListS() throws Exception
	{
		char ans;
		do
		{
			System.out.println("\n######### Search Page #########");
			System.out.println("Search Book By: ");
			System.out.println("0) Go To Book Option Page");
			System.out.println("1) Book Title");
			System.out.println("2) Author Name");
			System.out.println("3) Publication Year");
			System.out.println("Enter Your Choice: ");
			int choice = scanner.nextInt();
			MainView mainview = new MainView();
			switch(choice)
			{
			case 0: 
				mainview.getStaffViewBookOptions();
			case 1:
				System.out.println("Enter Book Title");
				String booktitle = scanner.next();
				booktitle = booktitle.toUpperCase();
				booklistview.displayBookListByBookNameS(booktitle);
				break;
			case 2:
				System.out.println("Enter Author First Name: ");
				String firstname = scanner.next();
				System.out.println("Enter Author Last Name: ");
				String lastname = scanner.next();
				firstname = firstname.toUpperCase();
				lastname = lastname.toUpperCase();
				booklistview.displayBookListByAuthorNameS(firstname, lastname);
				break;
			case 3:
				System.out.println("Enter Year: ");
				int year = scanner.nextInt();
				booklistview.displayBookListByYearS(year);
				break;
				
			default:
				System.out.println("Invalid Choice !!!");
				System.out.println("");
				searchBookListS();
			}
			System.out.println("\nDo You Want To Search Again [Y/N]: ");
			ans = scanner.next().charAt(0);
		
		}while(ans == 'y' || ans == 'Y');
	}
	public void setBorrowedBook() throws Exception
	{
		char ans;
		System.out.println("\n######### Request Book Page #########");
		System.out.println("NOTICE: ID Of Book Is Required For Requesting a Book !!!");
		System.out.println("");
		System.out.println("0) Go To Main Page");		
		System.out.println("1) Get ID'S of all books");
		System.out.println("2) Get ID of book based on <title> <publication year> <author name>");
		System.out.println("3) Go To Book Request Form Page");
		System.out.println("Enter Choice: ");
		int choice = scanner.nextInt();
		int bookid = 0;
		String submissiondate= "";
		MainView mainview = new MainView();
		switch(choice)
		{
		case 0: 
			mainview.getBorrowerMainView();
		case 1: 
			BookListView displayview = new BookListView();
			displayview.displayAllBookList();
			setBorrowedBook();
			break;
		case 2: 
			searchBookList();
			setBorrowedBook();
			break;
		case 3:
			do {
				System.out.println("\n######### Book Request Form Page #########");
				System.out.println("Enter Book ID: ");
				bookid = scanner.nextInt();
				System.out.println("Enter Submission Date (YYYY-MM-DD): ");
				submissiondate= scanner.next();
				BorrowedBookListController borrowedbooklistcontroller = new BorrowedBookListController();
				borrowedbooklistcontroller.setBorrowedBook(bookid,submissiondate);
				System.out.println("\nBook Request Form Submitted !!!!");
				System.out.println("You may visit Library for the book you've requested.\n");
				System.out.println("Do you want to request another book [Y/N]: ");
				ans = scanner.next().charAt(0);
			}while(ans == 'Y' || ans == 'y');
			break;
		default:
			System.out.println("Invalid Choice !!!");
			System.out.println("");
			setBorrowedBook();	
		}
		
	}
	
	public void displayBorrowerBorrowedBooks() throws SQLException
	{
		BorrowedBookListController borrowedbooklistcontroller = new BorrowedBookListController();
		borrowedbooklistcontroller.displayBorrowerBorrowedBooks();
	}
	public void displayLibrarianBorrowedBookList() throws SQLException
	{
		BorrowedBookListController borrowedbooklistcontroller = new BorrowedBookListController();
		borrowedbooklistcontroller.displayLibrarianBorrowedBookList();
	}
}
