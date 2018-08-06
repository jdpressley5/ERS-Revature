package dispatchers;
import java.sql.Connection;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import model.Reimbursement;
import utilities.Database;
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

	/**
	 * 
	 */
	public static void createReimbursementRequest(){
		Reimbursement re = new Reimbursement();
		//TOD get data into reimbursement
		RAO.createReimbursement(re);
	}//end createReimbursementRequest()
	
	/**
	 * 
	 * @return
	 */
	public static String viewEmployeePending() {
		int eid = 0;//TODO replace
		return GsonClass.gsonReimbursements(RAO.getFilterPendingReimbursements(eid));
	}//end employeePending()
	
	/**
	 * 
	 * @return
	 */
	public static String viewEmployeeResolved() {
		int eid = 0;//TODO replace
		return GsonClass.gsonReimbursements(RAO.getFilterResolvedReimbursements(eid));
	}//end viewEmployeeResolved()
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean signIn(String username, String password)
	{ return SAO.login(username, password, "EMP"); }

}//end class EmployeeDispatcher
