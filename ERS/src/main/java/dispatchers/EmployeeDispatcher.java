package dispatchers;
import java.sql.Connection;
import org.apache.log4j.Logger;
import dao_objects.EmployeeAccessObject;
import dao_objects.ReimbursementAccessObject;
import dao_objects.SignInAccessObject;
import model.Employee;
import servlet.FrontEndServlet;
import utilities.Database;
/** EmployeeDispatcher
 * Dispatcher for employee only actions
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class EmployeeDispatcher
{
	/** Logging object to record log4j messages.*/
    Logger log = Logger.getLogger(FrontEndServlet.class);
    /** The connection to the database. */
    Connection conn = Database.getConnection();
    /** Reference to the EAO */
    EmployeeAccessObject EAO = EmployeeAccessObject.getInstance();
    /** Reference to the RAO */
    ReimbursementAccessObject RAO = ReimbursementAccessObject.getInstance();
    /** Reference to Sign in object */
    static SignInAccessObject SAO = new SignInAccessObject();

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
