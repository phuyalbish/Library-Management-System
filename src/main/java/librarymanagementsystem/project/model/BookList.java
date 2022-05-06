package librarymanagementsystem.project.model;

public class BookList {
	int book_id;
	int available_book;
	String book_title;
	String category;
	int publication_year;
	String author_first_name;
	String author_last_name;
	
	public BookList(int book_id, int available_book,	String book_title,	String category,	int publication_year,	String author_first_name,	String author_last_name)
	{
		this.book_id = book_id;
		this.available_book = available_book;
		this.book_title = book_title;
		this.category = category;
		this.publication_year = publication_year;
		this.author_first_name = author_first_name;
		this.author_last_name = author_last_name;
	}
	
	public String toStringBorrower()
	{
		return "BOOK_ID: " + book_id + "\nBOOK_TITLE: " + book_title + "\nCATEGORY: " + category + "\nPUBLICATION_YEAR: " + publication_year + "\nAUTHOR_FIRST_NAME: " + author_first_name + "\nAUTHOR_SECOND_NAME: " +  author_last_name;

	}
	public String toStringLibrarian()
	{
		return "BOOK_ID: " + book_id + "\nAVAILABLE_BOOK: " + available_book + "\nBOOK_TITLE: " + book_title + "\nCATEGORY: " + category + "\nPUBLICATION_YEAR: " + publication_year + "\nAUTHOR_FIRST_NAME: " + author_first_name + "\nAUTHOR_SECOND_NAME: " +  author_last_name;

	}

	public int getBookId()
	{
		return book_id;
	}
	public String getFirstName()
	{
		return author_first_name;
	}
	public String getLastName()
	{
		return author_last_name;
	}

	public int getAvailableBook()
	{
		return available_book;
	}
}
