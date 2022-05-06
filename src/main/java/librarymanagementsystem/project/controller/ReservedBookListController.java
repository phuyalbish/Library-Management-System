package librarymanagementsystem.project.controller;
import java.util.*;
import java.sql.*;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.repository.ReservedBookRepository;

public class ReservedBookListController {
	ReservedBookRepository reservedbookrepository = new ReservedBookRepository();
	public void setRreservedBook(int bookid, String submissiondate, int userid) throws SQLException
	{
		reservedbookrepository.makeReservation(bookid, submissiondate, userid);
	}
	public void displayReservedBook() throws SQLException
	{
		List<ReservedBookList> reservedbooklists = reservedbookrepository.getReservedBookList();
		for(ReservedBookList reservedbooklist:reservedbooklists)
		{
			System.out.println("");
			System.out.println(reservedbooklist.toString());
		}
	}
}
