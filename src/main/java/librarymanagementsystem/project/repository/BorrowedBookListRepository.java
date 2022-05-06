package librarymanagementsystem.project.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import librarymanagementsystem.project.model.*;
import librarymanagementsystem.project.DBConnection;

public class BorrowedBookListRepository {
	public void setBorrowedBook(int bookid, String submissiondate, int userid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		System.out.println("SetBorrowedBook: " +userid);
		System.out.println("Submission: " +submissiondate);
		statement.executeUpdate("INSERT INTO borrowed_book(BOOK_ID, BORROWER_ID, BORROWED_DATE, SUBMISSION_DATE) VALUES(" + bookid +", " + userid + ",now(),'"+ submissiondate+"');");

	}
	
	public List<BorrowedBookList> getBorrowedBookListLibrarian() throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM borrowed_book_list");
		
		List<BorrowedBookList> borrowedbooklists = new ArrayList<>();
		while(rs.next())
		{
			BorrowedBookList borrowedbooklist = new BorrowedBookList(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
			borrowedbooklists.add(borrowedbooklist);
		}
		return borrowedbooklists;
	}
	
	public List<BorrowedBookList> getBorrowedBookListBorrower(int borrowerid) throws SQLException
	{
		Connection connection = DBConnection.getConn();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM borrowed_book_list WHERE BORROWER_ID = '" + borrowerid +"';");
		
		List<BorrowedBookList> borrowedbooklists = new ArrayList<>();
		while(rs.next())
		{
			BorrowedBookList borrowedbooklist = new BorrowedBookList(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10));
			borrowedbooklists.add(borrowedbooklist);
		}
		return borrowedbooklists;
	}
	
}
