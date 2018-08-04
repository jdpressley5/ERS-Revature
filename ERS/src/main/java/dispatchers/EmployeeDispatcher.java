package dispatchers;
import utilities.Assistant;

/** EmployeeDispatcher
 * Dispatcher for employee only actions
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class EmployeeDispatcher implements Assistant
{
	/** Singleton instance of this class */
	private static EmployeeDispatcher ED;
	/** No Args constructor hidden for singleton use. */
	private EmployeeDispatcher() {}

	/** Get instance of this class */
	static EmployeeDispatcher getInstance() {
		if (ED == null) ED = new EmployeeDispatcher();
		return ED;
	}//end getInstance()

	public static void createReimbursementRequest(){
		//TODO
	}//end createReimbursementRequest()
	
	public static void uploadImage() {
		//TODO LAST
	}//end uploadImage()
	
	public static void viewEmployeePending() {
		//TODO
	}//end employeePending()
	
	public static void viewEmployeeResolved() {
		//TODO
	}//end viewEmployeeResolved()
	
	public static boolean signIn(String username, String password)
	{ return SAO.login(username, password, "EMP"); }

}//end class EmployeeDispatcher
