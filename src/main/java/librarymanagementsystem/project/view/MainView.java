package librarymanagementsystem.project.view;
import java.util.Scanner;
import java.sql.*;
import librarymanagementsystem.project.controller.*;
public class MainView {
	Scanner scanner = new Scanner(System.in);
	BookListView booklistview = new BookListView();
	BorrowBookView borrowbookview = new BorrowBookView();
		public void getBorrowerMainView() throws SQLException, Exception
		{
			
			System.out.println("\n######### Library Management System #########");
			System.out.println("0) Go To Login Page");
			System.out.println("1) Display All Book Lists");
			System.out.println("2) Search Book Lists");
			System.out.println("3) Request Book");
			System.out.println("4) Display Requested Books");
			System.out.println("Enter choice: ");
			int choice = scanner.nextInt();

			LogInView loginview = new LogInView();
			switch(choice)
			{
			case 0: 
				loginview.displayAccounts();
			case 1:
				booklistview.displayAllBookList();
				System.out.println("");
				System.out.println("\nEnter 0 To Continue...");
				int num = scanner.nextInt();
				getBorrowerMainView();
				break;
			case 2:
				borrowbookview.searchBookList();
				System.out.println("");
				getBorrowerMainView();
				break;
			case 3:
				borrowbookview.setBorrowedBook();
				System.out.println("");
				getBorrowerMainView();
				break;
			case 4:
				borrowbookview.displayBorrowerBorrowedBooks();
				System.out.println("");
				getBorrowerMainView();
				break;
			default:
				System.out.println("Invalid Choice !!!");
				System.out.println("");
				getBorrowerMainView();
			}
		}
		public void getStaffMainView() throws Exception
		{			
			System.out.println("\n######### Library Management System #########");
			System.out.println("0) Go To Login Page");
			System.out.println("1) Book List");
			System.out.println("2) Requested Book List");
			System.out.println("3) Reserved Book List");
			System.out.println("4) Return Book");			
			System.out.println("Enter choice: ");
			int choice = scanner.nextInt();

			BorrowBookView borrowbookview = new BorrowBookView();
			LogInView loginview = new LogInView();
			ReturnBookView returnbookview = new ReturnBookView();
			ReserveBookView reservebookview = new ReserveBookView();
			switch(choice)
			{
			case 0: 
				loginview.displayAccounts();
			case 1:
				getStaffViewBookOptions();
				System.out.println("");
				getStaffMainView();
				break;
			case 2:
				borrowbookview.displayLibrarianBorrowedBookList();
				System.out.println("");
				getStaffMainView();
				break;
			case 3:
				System.out.println("Displaying Book Reservation List");
				reservebookview.displayReservedBook();
				System.out.println("");
				getStaffMainView();
				break;
			case 4:
				returnbookview.returnBook();
				System.out.println("\nBook Returned !!!\n");
				getStaffMainView();
				break;
			default:
				System.out.println("Invalid Choice !!!");
				System.out.println("");
				getStaffMainView();
			}
		}
		
		public void getStaffViewBookOptions() throws Exception
		{

			BookListController booklistcontroller = new BookListController();
			CategoryController categorycontroller = new CategoryController();
			
			System.out.println("######### Book Option Page #########");
			System.out.println("0) Go To Main Page");
			System.out.println("1) Display");
			System.out.println("2) Search");
			System.out.println("3) Add");
			System.out.println("4) Delete");
			System.out.println("5) Edit");
			System.out.println("Enter Choice: ");
			int choice = scanner.nextInt();
			BookListController booklist = new BookListController();
			char ans;
			switch(choice)
			{
			case 0: 
					getStaffMainView();
					break;
			case 1:
					booklistview.displayAllBookListS();
					System.out.println("\nEnter 0 To Continue...");
					int num = scanner.nextInt();
					getStaffViewBookOptions();
					break;
			case 2:
					borrowbookview.searchBookListS();
					System.out.println("");
					getStaffViewBookOptions();
					break;

			case 3:
					System.out.println("Enter Book Name: ");
					String booktitle = scanner.next();
					System.out.println("Enter Publication Year: ");
					int publicationyear = scanner.nextInt();
					System.out.println("Enter Number of Copies: ");
					int copies = scanner.nextInt();
					categorycontroller.displayCategory();
					System.out.println("Enter CategoryId or Press 0 to Add New Category: ");
					int categoryid = scanner.nextInt();
					if(categoryid == 0)
					{
						categoryid = categoryView();
					}
					System.out.println("Enter Author First Name: ");
					String authorfirstname = scanner.next();
					authorfirstname = authorfirstname.toUpperCase();
					System.out.println("Enter Author Last Name: ");
					String authorlastname = scanner.next();
					authorlastname = authorlastname.toUpperCase();
					booklistcontroller.addBook(booktitle, publicationyear, copies, categoryid, authorfirstname, authorlastname);
					getStaffViewBookOptions();
					break;
				
			case 4:
					booklistview.displayAllBookListS();
					do
					{
						System.out.println("\nEnter ID of Book You Wish to Delete: ");
						int bookid = scanner.nextInt();
						booklist.deleteBook(bookid);
						System.out.println("Selected Book Deleted !!!");
						System.out.println("Want to delete another book [Y/N]: ");
						ans = scanner.next().charAt(0);
					}while(ans == 'Y' || ans == 'y');
					getStaffViewBookOptions();
					break;
					
			case 5:
					do
					{
						booklistview.displayAllBookListS();
						System.out.println("\nEnter ID of Book You Wish to Edit: ");
						int bookid = scanner.nextInt();
						System.out.println("Enter Book Name: ");
						booktitle = scanner.next();
						System.out.println("Enter Publication Year: ");
						publicationyear = scanner.nextInt();
						System.out.println("Enter Number of Copies: ");
						copies = scanner.nextInt();
						categorycontroller.displayCategory();
						System.out.println("Enter CategoryId or Press 0 to Add New Category: ");
						categoryid = scanner.nextInt();
						if(categoryid == 0)
						{
							categoryid = categoryView();
						}
						System.out.println("Enter Author First Name: ");
						authorfirstname = scanner.next();
						authorfirstname = authorfirstname.toUpperCase();
						System.out.println("Enter Author Last Name: ");
						authorlastname = scanner.next();
						authorlastname = authorlastname.toUpperCase();
						booklistcontroller.editBookDetails(bookid,booktitle, publicationyear, copies, categoryid, authorfirstname, authorlastname);
						System.out.println("\nBook Details Updated !!!\n");
						System.out.println("Want to Edit another book [Y/N]: ");
						ans = scanner.next().charAt(0);
					}while(ans == 'Y' || ans == 'y');
					getStaffViewBookOptions();
					break;
			default:
				System.out.println("Invalid Choice !!!");
				getStaffViewBookOptions();
			}
		}
		public int categoryView() throws SQLException
		{
			System.out.println("Enter Category Name: ");
			String categoryname = scanner.next();
			categoryname = categoryname.toUpperCase();
			CategoryController categorycontroller = new CategoryController();
			categorycontroller.insertCategory(categoryname);
			return categorycontroller.getCategoryId(categoryname);
		}
}
