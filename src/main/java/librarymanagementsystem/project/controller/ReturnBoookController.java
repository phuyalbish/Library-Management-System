package librarymanagementsystem.project.controller;
import librarymanagementsystem.project.repository.*;
import librarymanagementsystem.project.model.*;
import java.sql.*;
import java.util.*;
public class ReturnBoookController {
	ReturnBookRepository returnbookrepository = new ReturnBookRepository();
	BorrowedBookListRepository borrowedbooklistrepository = new BorrowedBookListRepository();
	BookListRepository booklistrepository = new BookListRepository();
	public void returnBook(int borrowedbookid) throws SQLException
	{
		List<BorrowedBookList> borrowedbooklists = borrowedbooklistrepository.getBorrowedBookListLibrarian();
		for(BorrowedBookList borrowedbooklist:borrowedbooklists)
		{
			if(borrowedbooklist.getBorrowedBookId() == borrowedbookid)				
			{
				int availablebook = borrowedbooklist.getAvailableBook();
				availablebook = availablebook + 1;
				returnbookrepository.returnBook(borrowedbookid, borrowedbooklist.getBookId(),borrowedbooklist.getBorrowerId());
				booklistrepository.inc_dec_AvailableBook(borrowedbooklist.getBookId(), availablebook);
			}
		}
	}
	public void displayReturnedBooks() throws SQLException
	{
		List<ReturnedBookList> returnedbooklists = returnbookrepository.displayReturnedBooks();
		for(ReturnedBookList returnedbooklist:returnedbooklists)
		{
			System.out.println("");	
			System.out.println(returnedbooklist.toString());
		}
	}
	
}
