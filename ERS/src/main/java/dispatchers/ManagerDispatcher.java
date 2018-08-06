package dispatchers;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import utilities.GsonClass;
import model.Employee;
import model.Reimbursement;
import java.util.Map;

/** ManagerDispatcher
 * Dispatcher for manager only actions
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/6/2018 */
public class ManagerDispatcher 
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(ManagerDispatcher.class);
    /** Reference to the EAO */
    static EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    static ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    
	//------------------------------------------------------------------------------
	// Singleton
	//------------------------------------------------------------------------------
	/** Singleton instance of this class */
	private static ManagerDispatcher MD;
	/** No Args constructor hidden for singleton use. */
	private ManagerDispatcher() {}
	/** Get instance of this class */
	static ManagerDispatcher getInstance() {
		if (MD == null) MD = new ManagerDispatcher();
		return MD;
	}//end getInstance()

	//------------------------------------------------------------------------------
	//  Methods
	//------------------------------------------------------------------------------

	/** Approves a request
	 * @param params parameters from client */
	public static void respond(Map<String,String> params) { 
		Reimbursement re = new Reimbursement();
		re.setR_id(Integer.parseInt(params.get("rid")));
		String message = params.get("message");
		boolean apr = Boolean.parseBoolean(params.get("apr"));
		RAO.approveDenyRequest(apr, message, re); 
	}//end respond()
	
	/** gets all pending requests
	 * @return string of pending requests */
	public static String getAllPending() 
	{ return GsonClass.gsonReimbursements(RAO.getPendingReimbursements()); }
	
	/** gets all resolved requests
	 * @return string of resolved requests */
	public static String getAllResolved()
	{ return GsonClass.gsonReimbursements(RAO.getResolvedReimbursements());}
	
	/** Gets all employees
	 * @return string of all employees */
	public static String getAllEmployees() 
	{ return GsonClass.gsonEmployees(EAO.getAllEmployees()); }
	
	/** Signs in manger
	 * @param username username
	 * @param password password
	 * @return success or failure for signin */ 
	public static boolean signIn(String username, String password)
	{ return new SignInAccessObject().login(username, password, "MGR"); }

	/** creates an employee and adds it to the database.
	 * @param params params to create employee
	 * @return boolean successful? */
	public static boolean createEmp(Map<String,String> params)
	{	Employee emp = new Employee();
		emp.setFirstName(params.get("fname"));
		emp.setLastName(params.get("lname"));
		emp.setPassword(params.get("password"));
		emp.setUsername(params.get("username"));		
		return EAO.createEmployee(emp);
	}//end createEmp()
}//end class ManagerDispatcher
