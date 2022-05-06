package librarymanagementsystem.project.model;

public class BorrowedBookList {
	int borrowedbookid;
	int borrowerid;
	String borrowername;
	String email;
	int contact;
	int bookid;
	int availablebook;
	String booktitle;
	String borroweddate;
	String submissiondate;
	
	public BorrowedBookList(int borrowedbookid, int borrowerid, String borrowername, String email, int contact, int bookid, int availablebook, String booktitle, String borroweddate, String submissiondate)
	{
		this.borrowedbookid = borrowedbookid;
		this.borrowerid = borrowerid;
		this.borrowername = borrowername;
		this.email = email;
		this.contact = contact;
		this.bookid = bookid;
		this.availablebook = availablebook;
		this.booktitle = booktitle;
		this.borroweddate = borroweddate;
		this.submissiondate = submissiondate;
	}
	
	public String toStringBorrrower()
	{
		return "BOOK_TITLE: " +  booktitle + "\nBORROWED_DATE: " +  borroweddate +"\nSUBMISSION_DATE: " +  submissiondate;
	}
	public String toStringLibrarian()
	{
		return "BORROWED_BOOK_ID: " + borrowedbookid + "\nBORROWER_NAME: " + borrowername + "\nEMAIL: " + email + "\nContact No: " + contact +"\nBOOK_TITLE: " +  booktitle +"\nBORROWED_DATE: " +  borroweddate +"\nSUBMISSION_DATE: " +  submissiondate;
	}
	public int getBorrowedBookId()
	{
		return borrowedbookid;
	}

	public int getBorrowerId()
	{
		return borrowerid;
	}
	public int getBookId()
	{
		return bookid;
	}

	public int getAvailableBook()
	{
		return availablebook;
	}
	public String getBorrowedDate()
	{
		return borroweddate;
	}
	public String getSubmissonDate()
	{
		return submissiondate;
	}
}
