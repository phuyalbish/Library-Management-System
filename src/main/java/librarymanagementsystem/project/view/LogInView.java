package librarymanagementsystem.project.view;
import java.sql.*;
import java.util.Scanner;
import librarymanagementsystem.project.controller.*;
public class LogInView {
	Scanner scanner = new Scanner(System.in);
	LogInController logincontroller = new LogInController();
	MainView mainview = new MainView();
	public void displayAccounts() throws SQLException, Exception
	{
		System.out.println("######### Select Account Type #########");
		System.out.println("0) Exit");
		System.out.println("1) Member");
		System.out.println("2) Staff");
		System.out.println("Enter Choice: ");
		int choice = scanner.nextInt();
				
		switch(choice)
		{
		case 0:
			System.out.println("Exiting the program !!!");
			System.exit(0);
			break;
		
		case 1:
			memberView();
			
		case 2:
			staffView();
			
		default:
			System.out.println("Invalid Choice !!!");
			displayAccounts();
		}
	}
	public void memberView() throws Exception
	{
		System.out.println("######### Login Page #########");
		System.out.println("\nEnter Your Email: ");
		String email = scanner.next();
		if(logincontroller.memberLogIn(email))
			mainview.getBorrowerMainView();
		else
		{
			System.out.println("Invalid Email!!! Enter Valid Email Address");
			displayAccounts();
		}
	}
	public void staffView() throws Exception
	{
		System.out.println("######### Login Page #########");
		System.out.println("\nEnter Your Email: ");
		String email = scanner.next();
		if(logincontroller.staffLogIn(email))
			mainview.getStaffMainView();
		else
		{
			System.out.println("Invalid Email!!! Enter Valid Email Address");
			displayAccounts();
		}
	}
}
