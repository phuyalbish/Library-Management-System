package librarymanagementsystem.project.model;

public class LogIn {
	int userid;
	String currentuser;
	
	public LogIn(int userid, String email)
	{
		this.userid = userid;
		currentuser = email;
	}
	public int getUserId()
	{
		return userid;
	}
	public String getUserEmail()
	{
		return currentuser;
	}
}
