package dispatchers;
import java.util.List;
import java.util.Map;
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

	public static String dispatch(HttpServletRequest request, HttpServletResponse response, Map<String, String> params) 
	{		
		String[] guts = request.getRequestURI().split("/");
		switch (guts[3]) 
		{
			case "loginE.do": // employee home
				boolean res = EmployeeDispatcher.signIn(params.get("username"), params.get("password"));
				if (res)
					return "http://localhost:8080/ERS/HTML/EHome.html";
				break;
			case "loginM.do": // manager home
				res = ManagerDispatcher.signIn(params.get("username"), params.get("password"));
				System.out.println(res);
				if (res)
					return "http://localhost:8080/ERS/HTML/MHome.html";
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
		return "http://localhost:8080/ERS/HTML/empty.html";
	}//end dispatch()
}//end class MasterDispatcher
