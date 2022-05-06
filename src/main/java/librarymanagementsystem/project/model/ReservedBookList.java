package librarymanagementsystem.project.model;

public class ReservedBookList {
	String borrowername;
	String email;
	int contact;
	String booktitle;
	String reserveddate;
	
	public ReservedBookList(String borrowername, String email, int contact, String booktitle, String reserveddate)
	{
		this.borrowername = borrowername;
		this.email = email;
		this.contact = contact;
		this.booktitle = booktitle;
		this.reserveddate = reserveddate;
	}

	public String toString()
	{
		return "\nBORROWER_NAME: " + borrowername + "\nEMAIL: " + email + "\nContact No: " + contact +"\nBOOK_TITLE: " +  booktitle +"\nRESERVED_DATE: " +  reserveddate;
	}
}
