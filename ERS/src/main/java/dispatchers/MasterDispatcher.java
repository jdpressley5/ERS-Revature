package dispatchers;
import java.io.IOException;
import java.sql.Connection;

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
		String[] guts = request.getRequestURI().split("/");
		System.out.println(guts[3]);
		String s = guts[3];
		System.out.println("String to filter is " + s);
		System.out.println(s.equals("loginM.do"));
		switch (s) 
		{
			case "loginE.do": // employee home
				boolean res = EmployeeDispatcher.signIn(request.getParameter("username"), request.getParameter("password"));
				if (res)
					return "EHome.html";
				break;
			case "loginM.do": // manager home
				res = ManagerDispatcher.signIn(request.getParameter("username"), request.getParameter("password"));
				System.out.println("result from signin-m : " + res);
				if (res)
					return "http://localhost:8080/ERS/HTML/Manager/MHome.html";
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
		return "INVALID PATH";
	}//end dispatch()
}//end class MasterDispatcher
