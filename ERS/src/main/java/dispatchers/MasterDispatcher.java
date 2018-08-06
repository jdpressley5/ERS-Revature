package dispatchers;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
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

    /** Dispatches work to the service classes.
     * @param request request object
     * @param response response object
     * @param params params from the web page
     * @return String stuff to send back to the client */
	public static String dispatch(HttpServletRequest request, HttpServletResponse response, Map<String, String> params) 
	{		
		String[] guts = request.getRequestURI().split("/");
		switch (guts[3]) {
			case "loginE.do": // employee home
				boolean res = EmployeeDispatcher.signIn(params.get("username"), params.get("password"));
				if (res) return "SUCCESS";
				else return "FAILED";
				
			case "loginM.do": // manager home
				res = ManagerDispatcher.signIn(params.get("username"), params.get("password"));
				if (res) return "SUCCESS";
				else return "FAILED";
				
			case "create.do":// create employee
				res = ManagerDispatcher.createEmp(params);
				if (res) return "SUCCESS";
				else return "FAILED";
				
			case "pending.do":// view reimbursement pending
				if (params.get("eid") != null) //TODO revise
				{ return EmployeeDispatcher.viewEmployeePending(Integer.parseInt(params.get("eid"))); }
				else { return ManagerDispatcher.getAllPending(); }
				
			case "resolved.do":// view reimbursement resolved 
				if (params.get("eid") != null) //TODO revise
				{ return EmployeeDispatcher.viewEmployeeResolved(Integer.parseInt(params.get("eid"))); }
				else { return ManagerDispatcher.getAllResolved(); }
				
			case "profiles.do":// view employees
				return ManagerDispatcher.getAllEmployees();
				
			case "logout.do": // logout
				return "Successfully Logged out of ERS";
				
			case "subReq.do": //submit request
				return EmployeeDispatcher.createReimbursementRequest(params);
				
			case "update.do": //update employee
				return CommonDispatcher.updateEmployeeInformation(params);
				
			case "viewE.do": //view employee
				return CommonDispatcher.viewEmployeeProfile(10000);//TODO remove value
				
			case "aprv.do": //approve request
				params.put("apr", "true");
				ManagerDispatcher.respond(params);
				return "Approve Completed";
				
			case "deny.do": //deny request
				params.put("apr", "false");
				ManagerDispatcher.respond(params);
				return "Deny Completed";
		}//end switch
		return "THIS IS A MESSAGE";//TODO replace
	}//end dispatch()
}//end class MasterDispatcher
