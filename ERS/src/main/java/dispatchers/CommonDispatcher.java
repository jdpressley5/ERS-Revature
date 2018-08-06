package dispatchers;
import java.util.Map;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import model.Employee;
import utilities.GsonClass;

/** CommonDispatcher
 * Dispatcher for common actions for both manger and employee
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/6/2018 */
public class CommonDispatcher
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(CommonDispatcher.class);
    /** Reference to the EAO */
    static EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
	
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
	
	/** Gets the employee information based on ID number.
	 * @param ID ID number of employee
	 * @return JSON string of employee information. */
	public static String viewEmployeeProfile(int ID) 
	{ return GsonClass.gsonIndividual(EAO.getIndividual(ID)); }
	
	public static void updateEmployeeInformation(Map<String,String> params) {
		Employee emp = new Employee();
		emp.setFirstName(params.get("fname"));
		emp.setLastName(params.get("lname"));
		emp.setAddress(params.get("address"));
		emp.setEmail(params.get("email"));
		emp.setPassword(params.get("password"));
		emp.setUsername(params.get("username"));
		EAO.updateEmployee(emp);
	}//end updateEmployeeInformation()
}//end class CommonDispatcher
