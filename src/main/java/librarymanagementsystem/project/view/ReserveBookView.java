package librarymanagementsystem.project.view;
import java.util.Scanner;
import librarymanagementsystem.project.controller.*;
import java.sql.*;
public class ReserveBookView {
	Scanner scanner = new Scanner(System.in);
	public void reserveBook(int bookid, String submissiondate, int userid) throws SQLException
	{
		System.out.println("\nWe Apologize for the Inconvenience But the Book You've Requested is Out of Stock\n");
		System.out.println("Would You Like to Make a Reservation for the Book [Y/N]");
		char ans = scanner.next().charAt(0);
		if(ans == 'Y' || ans == 'y')
		{
			ReservedBookListController reservedbooklistcontroller = new ReservedBookListController();
			reservedbooklistcontroller.setRreservedBook(bookid, submissiondate, userid);
		}
			
	}
	public void displayReservedBook() throws SQLException
	{
		ReservedBookListController reservedbooklistcontroller = new ReservedBookListController();
		reservedbooklistcontroller.displayReservedBook();
	}
}
