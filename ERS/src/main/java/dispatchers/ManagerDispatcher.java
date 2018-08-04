package dispatchers;
import model.Employee;
import java.sql.Connection;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import servlet.FrontEndServlet;
import utilities.Database;
import model.Reimbursement;
import java.util.ArrayList;

/** ManagerDispatcher
 * Dispatcher for manager only actions
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class ManagerDispatcher 
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(FrontEndServlet.class);
    /** The connection to the database. */
    static Connection conn = Database.getConnection();
    /** Reference to the EAO */
    static EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    static ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    /** Reference to Sign in object */
    static SignInAccessObject SAO = new SignInAccessObject();
    
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
	 * @param message message to reply with
	 * @param re Reimbursement object*/
	public static void approveResponse(String message, Reimbursement re)
	{ RAO.approveDenyRequest(true, message, re); }

	/** Denies a request
	 * @param message message to reply with
	 * @param re Reimbursement object */
	public static void denyResponse(String message, Reimbursement re)
	{ RAO.approveDenyRequest(false, message, re); }
	
	public static void getAllPending() {
		ArrayList<Reimbursement> results = RAO.getPendingReimbursements();
		//TODO finish
	}//end getAllPending()
	
	public static void getAllResolved(){
		ArrayList<Reimbursement> results = RAO.getResolvedReimbursements();
		//TODO finish
	}//end getAllResolved()
	
	public static void getAllEmployees(){
		ArrayList<Employee> results = EAO.getAllEmployees();
		//TODO finish
	}//end getAllEmployees()
	
	public static boolean signIn(String username, String password)
	{ return SAO.login(username, password, "MGR"); }
}//end class ManagerDispatcher
