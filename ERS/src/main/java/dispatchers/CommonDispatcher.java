package dispatchers;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	/** updates an employees information
	 * @param params parameters to pull from
	 * @return success mesage*/
	public static String updateEmployeeInformation(Map<String,String> params) {
		String pass = params.get("password");
    	try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(pass.getBytes(),0,pass.length());
			pass = new BigInteger(1,m.digest()).toString(16).toUpperCase();
			
		}//end try 
		catch (NoSuchAlgorithmException e1) {log.error("MD5 hash missing"); }
		
		Employee emp = new Employee();
		emp.setFirstName(params.get("fname"));
		emp.setLastName(params.get("lname"));
		emp.setAddress(params.get("address"));
		emp.setEmail(params.get("email"));
		emp.setPassword(pass);
		emp.setIdNumber(Integer.parseInt(params.get("eid")));
		emp.setUsername(params.get("username"));
		EAO.updateEmployee(emp);
		return "successful update";
	}//end updateEmployeeInformation()
}//end class CommonDispatcher
