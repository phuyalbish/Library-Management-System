package librarymanagementsystem.project;
import librarymanagementsystem.project.view.*;
import java.sql.*;
/**
 * Hello world!
 *
 */
public class mainApp 
{
    public static void main( String[] args ) throws Exception
    {
    	LogInView login = new LogInView();
    	login.displayAccounts();
    }
}
