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
import model.Employee;
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
				if (res)
					return "http://localhost:8080/ERS/HTML/MHome.html";
				break;
			case "create.do":// create employee
				res = ManagerDispatcher.createEmp(params);
				if (res)
					return "http://localhost:8080/ERS/HTML/.html";
				break; 
			case "pending.do":// view reimbursement pending
				break; 
			case "resolved.do":// view reimbursement resolved
				break; 
			case "profiles.do":// view employees
				break; 
			case "logout.do": // logout
				break; 
			case "subReq.do": //submit request
				break; 
			case "update.do": //update employee
				break; 
			default: 
		}// end switch
		return "http://localhost:8080/ERS/HTML/404.html";
	}//end dispatch()
}//end class MasterDispatcher
