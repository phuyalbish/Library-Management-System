package librarymanagementsystem.project.view;
import java.sql.*;
import java.util.Scanner;
import librarymanagementsystem.project.controller.*;
public class ReturnBookView {
	Scanner scanner = new Scanner(System.in);
	BorrowBookView borrowbookview = new BorrowBookView();
	ReturnBoookController returnbookcontroller = new ReturnBoookController();
	public void returnBook() throws SQLException
	{
		System.out.println("Displaying Borrowed Books....");
		borrowbookview.displayLibrarianBorrowedBookList();
		System.out.println("\nEnter BorrowedBookId: ");
		int borrowedbookid = scanner.nextInt();
		returnbookcontroller.returnBook(borrowedbookid);
	}
}
