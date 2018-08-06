package dispatchers;
import java.util.Map;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import utilities.Database;

/** MasterDispatcher
 * Dispatcher that distributes to the appropriate dispatchers.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/6/2018 */
public class MasterDispatcher
{	
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(MasterDispatcher.class);
    /** The connection to the database. */
    static Connection conn = Database.getConnection();
    /** Reference to the EAO */
    static EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    static ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    /** Reference to Sign in object */
    static SignInAccessObject SAO = new SignInAccessObject();

    /** Dispatches work to the service classes.
     * @param request request object
     * @param response response object
     * @param params params from the web page
     * @return String stuff to send back to the client */
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
					return "";//TODO fix this
				break; 
			case "pending.do":// view reimbursement pending
				//TODO
				break; 
			case "resolved.do":// view reimbursement resolved
				//TODO
				break; 
			case "profiles.do":// view employees
				//TODO
				break; 
			case "logout.do": // logout
				//TODO
				break; 
			case "subReq.do": //submit request
				//TODO
				break; 
			case "update.do": //update employee
				//TODO
				break; 
			case "viewE.do": //view employee
				//TODO
				break;
		}// end switch
		return "http://localhost:8080/ERS/HTML/404.html";
	}//end dispatch()
}//end class MasterDispatcher
