package dispatchers;
import java.util.List;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import servlet.FrontEndServlet;
import utilities.Database;

/** MasterDispatcher
 * Dispatcher that distributes to the appropriate dispatchers.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class MasterDispatcher
{	
	/** Logging object to record log4j messages.*/
    Logger log = Logger.getLogger(FrontEndServlet.class);
    /** The connection to the database. */
    Connection conn = Database.getConnection();
    /** Reference to the EAO */
    EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    /** Reference to Sign in object */
    SignInAccessObject SAO = new SignInAccessObject();

	public static String dispatch(HttpServletRequest request, HttpServletResponse response) 
	{		
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) { System.out.println(parameterNames.nextElement()); }
		System.out.println("printed");
		
		String[] guts = request.getRequestURI().split("/");
		String s = guts[3];
		
		switch (s) 
		{
			case "loginE.do": // employee home
				boolean res = EmployeeDispatcher.signIn(request.getParameter("username"), request.getParameter("password"));
				if (res)
					return "EHome.html";
				break;
			case "loginM.do": // manager home
				System.out.println("Username " + request.getParameter("username"));
				System.out.println("Password " + request.getParameter("password"));
				res = ManagerDispatcher.signIn(request.getParameter("username"), request.getParameter("password"));
				if (res)
					return "MHome.html";
				break;
			case "3":
				break; // create reimbursement
			case "2":
				break; // view reimbursement
			case "5":
				break; // view reimbursements
			case "4":
				break; // view employees
			case "6":
				break; // logout
			case "7":
				break; // view an employee
			case "8":
				break; // update user info
			default: // page not found
		}// end switch
		return "404.html";
	}//end dispatch()
}//end class MasterDispatcher
