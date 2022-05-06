package librarymanagementsystem.project.controller;
import java.sql.*;
import librarymanagementsystem.project.repository.*;
import librarymanagementsystem.project.model.*;
import java.util.List;
public class LogInController {
	LogInRepository loginrepository = new LogInRepository();
	private LogIn currentmember = null; 
	public boolean memberLogIn(String email) throws SQLException
	{
		List<LogIn> members = loginrepository.memberLogIn();
		for(LogIn member:members) {
			if(member.getUserEmail().equals(email))
			{
				currentmember = member;
				CurrentMemberRepository currentmemberrepository = new CurrentMemberRepository();
				currentmemberrepository.setCurrentMember(member.getUserId());
			}
		}
		return currentmember != null;
	}
	public boolean staffLogIn(String email) throws SQLException
	{
		List<LogIn> members = loginrepository.staffLogIn();
		for(LogIn member:members) {
			if(member.getUserEmail().equals(email))
				currentmember = member;
		}
		return currentmember != null;
	}
}
