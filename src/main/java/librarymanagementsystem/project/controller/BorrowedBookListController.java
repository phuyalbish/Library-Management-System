package librarymanagementsystem.project.controller;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.repository.*;
import librarymanagementsystem.project.view.BorrowBookView;
import librarymanagementsystem.project.view.ReserveBookView;

import java.text.*;
import java.util.*;
import java.sql.*;
public class BorrowedBookListController {
	BorrowedBookListRepository borrowedbooklistrepository = new BorrowedBookListRepository();
	CurrentMemberController currentmembercontroller = new CurrentMemberController();
	public void displayLibrarianBorrowedBookList() throws SQLException
	{
		List<BorrowedBookList> borrowedbooklists = borrowedbooklistrepository.getBorrowedBookListLibrarian();
		for(BorrowedBookList borrowedbooklist:borrowedbooklists)
		{
			
			System.out.println("");
			System.out.println(borrowedbooklist.toStringLibrarian());
		}
	}
	public void displayBorrowerBorrowedBooks() throws SQLException
	{
		int borrowerid = currentmembercontroller.getUserId();
		System.out.println("Borrowed Books !!!");
		BorrowedBookListRepository borrowedbooklistrepository = new BorrowedBookListRepository();
		List<BorrowedBookList> borrowedbooklists = borrowedbooklistrepository.getBorrowedBookListBorrower(borrowerid);
		
		for(BorrowedBookList borrowedbooklist : borrowedbooklists)
		{
			System.out.println("");
			System.out.println(borrowedbooklist.toStringBorrrower());
		}
	}
	public void setBorrowedBook(int bookid, String submissiondate) throws SQLException, Exception
	{
		DateController datecontroller = new DateController();			
		if(datecontroller.isDateGreater(submissiondate))
		{		
			BookListRepository booklistrepository = new BookListRepository();
			CurrentMemberController currentmembercontroller = new CurrentMemberController();
			
			List<BookList> booklists = booklistrepository.getAllBookList();
			for(BookList booklist:booklists)
			{
				if(booklist.getBookId() == bookid)
				{
					int availablebook = booklist.getAvailableBook();
					if(availablebook == 0)
					{
						ReserveBookView reservebookview = new ReserveBookView();
						reservebookview.reserveBook(bookid, submissiondate, currentmembercontroller.getUserId());
					}
					else
					{
						availablebook = availablebook - 1;
						borrowedbooklistrepository.setBorrowedBook(bookid, submissiondate,currentmembercontroller.getUserId());
						booklistrepository.inc_dec_AvailableBook(bookid, availablebook);
					}
				}
			}
		}
		else
		{
			BorrowBookView borrowbookview = new BorrowBookView();
			System.out.println("\nSubmission Date Not Valid!!!\n");
			borrowbookview.setBorrowedBook();
		}
		
	}
		
}
