package librarymanagementsystem.project.model;

public class ReturnedBookList {
	int returnedbookid;
	String borrowername;
	String email;
	int contact;
	String booktitle;
	String returneddate;
	
	public ReturnedBookList(int returnedbookid, String borrowername, String email, int contact, String booktitle, String returneddate)
	{
		this.returnedbookid = returnedbookid;
		this.borrowername = borrowername;
		this.email = email;
		this.contact = contact;
		this.booktitle = booktitle;
		this.returneddate = returneddate;
	}

	public String toString()
	{
		return "RETURNED_BOOK_ID: " + returnedbookid + "\nBORROWER_NAME: " + borrowername + "\nEMAIL: " + email + "\nContact No: " + contact +"\nBOOK_TITLE: " +  booktitle +"\nRETURNED_DATE: " +  returneddate;
	}
}
