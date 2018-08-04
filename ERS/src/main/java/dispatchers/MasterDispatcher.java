package dispatchers;
import utilities.Assistant;

/** MasterDispatcher
 * Dispatcher that distributes to the appropriate dispatchers.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class MasterDispatcher implements Assistant
{
	/** Instance of the common Dispatcher */
	private static CommonDispatcher CD = CommonDispatcher.getInstance();
	/** Instance of the employee Dispatcher */
	private static EmployeeDispatcher ED = EmployeeDispatcher.getInstance();
	/** Instance of the manager Dispatcher */
	private static ManagerDispatcher MD = ManagerDispatcher.getInstance();
	
	//--------------------------------------------------------------
	
	public static void dispatch() {
		//TODO
		String redirect = "";
		switch (redirect){
			case "": break; //employee home
			case "1": break; //manager home
			case "3": break; //create reimbursement
			case "2": break; //view reimbursement
			case "5": break; //view reimbursements
			case "4": break; //view employees
			case "6": break; //logout
			case "7": break; //view an employee
			case "8": break; //update user info
			default: //page not found
		}//end switch
	}//end dispatch
}//end class MasterDispatcher
