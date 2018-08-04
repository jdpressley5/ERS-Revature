package dispatchers;
import model.Employee;
import utilities.Assistant;

/** CommonDispatcher
 * Dispatcher for common actions for both manger and employee
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class CommonDispatcher implements Assistant
{
	//------------------------------------------------------------------------------
	// Singleton
	//------------------------------------------------------------------------------
	/** Singleton instance of this class */
	private static CommonDispatcher CD;
	/** No Args constructor hidden for singleton use. */
	private CommonDispatcher() {}

	/** Get instance of this class */
	static CommonDispatcher getInstance() {
		if (CD == null) CD = new CommonDispatcher();
		return CD;
	}//end getInstance()

	//------------------------------------------------------------------------------
	// Methods
	//------------------------------------------------------------------------------
	public static void viewEmployeeProfile(int ID) {
		//TODO
		EAO.getIndividual(ID);
	}//end viewEmployeeProfile()
	
	public static void updateEmployeeInformation() {
		Employee emp = new Employee();
		//TODO get form data
		// TODO pass form data into Employee
		EAO.updateEmployee(emp);
	}//end updateEmployeeInformation()
}//end class CommonDispatcher
