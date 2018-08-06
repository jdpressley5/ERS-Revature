package dispatchers;
import java.sql.Connection;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import model.Employee;
import servlet.FrontEndServlet;
import utilities.Database;
import utilities.GsonClass;

/** CommonDispatcher
 * Dispatcher for common actions for both manger and employee
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class CommonDispatcher
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(CommonDispatcher.class);
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
	
	public static void updateEmployeeInformation() {
		Employee emp = new Employee();
		//TODO get form data into emp
		EAO.updateEmployee(emp);
	}//end updateEmployeeInformation()
}//end class CommonDispatcher
