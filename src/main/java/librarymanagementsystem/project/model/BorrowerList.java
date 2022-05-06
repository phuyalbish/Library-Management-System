package librarymanagementsystem.project.model;

public class BorrowerList {
	String book_title;
	String category;
	int publication_year;
	String author_first_name;
	String author_last_name;
	
	public BorrowerList(String book_title,	String category,	int publication_year,	String author_first_name,	String author_last_name)
	{
		this.book_title = book_title;
		this.category = category;
		this.publication_year = publication_year;
		this.author_first_name = author_first_name;
		this.author_last_name = author_last_name;
	}
	
	public String toString()
	{
		return " BOOK_TITLE: " + book_title + " CATEGORY: " + category + " PUBLICATON_YEAR: " + publication_year + " AUTHOR_FIRST_NAME: " + author_first_name + " AUTHOR_SECOND_NAME: " +  author_last_name;

	}
}
