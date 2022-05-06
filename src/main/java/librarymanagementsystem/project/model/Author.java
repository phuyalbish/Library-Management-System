package librarymanagementsystem.project.model;

public class Author {
	int id;
	String firstname;
	String lastname;
	
	public Author(int id, String firstname, String lastname)
	{
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getId()
	{
		return id;
	}
	public String getFirstName()
	{
		return firstname;
	}
	public String getLastName()
	{
		return lastname;
	}
	
}
