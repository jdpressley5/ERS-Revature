package dispatchers;
import java.util.Map;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import model.Reimbursement;
import utilities.GsonClass;

/** EmployeeDispatcher
 * Dispatcher for employee only actions
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/5/2018 */
public class EmployeeDispatcher
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(EmployeeDispatcher.class);
    /** Reference to the EAO */
    static EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    static ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    //------------------------------------------------------------------------------
  	// Singleton
  	//------------------------------------------------------------------------------
	/** Singleton instance of this class */
	private static EmployeeDispatcher ED;
	/** No Args constructor hidden for singleton use. */
	private EmployeeDispatcher() {}
	/** Get instance of this class */
	static EmployeeDispatcher getInstance() {
		if (ED == null) ED = new EmployeeDispatcher();
		return ED;
	}//end getInstance()
	
	//------------------------------------------------------------------------------
	//  Methods
	//------------------------------------------------------------------------------

	/** create a reimbursement
 	* @param params parameters from client */
	public static void createReimbursementRequest(Map<String,String> params){
		Reimbursement re = new Reimbursement();
		//TOD get data into reimbursement
		RAO.createReimbursement(re);
	}//end createReimbursementRequest()
	
	/** Gets pending reimbursements for employee
	 * @return String of pending reimbursements for employee */
	public static String viewEmployeePending(int eid) 
	{ return GsonClass.gsonReimbursements(RAO.getFilterPendingReimbursements(eid)); }
	
	/** Gets resolved reimbursements for employee
	 * @return String of resolved reimbursements for employee */
	public static String viewEmployeeResolved(int eid) 
	{ return GsonClass.gsonReimbursements(RAO.getFilterResolvedReimbursements(eid)); }
	
	/** Signs in employee
	 * @param username username
	 * @param password password
	 * @return success/fail */
	public static boolean signIn(String username, String password)
	{ return new SignInAccessObject().login(username, password, "EMP"); }

}//end class EmployeeDispatcher
