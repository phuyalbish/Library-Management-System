package librarymanagementsystem.project.controller;

import java.sql.SQLException;

import librarymanagementsystem.project.model.CurrentMember;
import librarymanagementsystem.project.repository.CurrentMemberRepository;

public class CurrentMemberController {
	public int getUserId() throws SQLException
	{
		CurrentMemberRepository currentmemberrepository = new CurrentMemberRepository();
		CurrentMember currentmember = currentmemberrepository.getCurrentMember();
		return currentmember.getCurrentuserId();
	}
}
