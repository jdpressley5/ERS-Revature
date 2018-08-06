package utilities;
import java.util.ArrayList;
import com.google.gson.Gson;
import model.Employee;
import model.Reimbursement;

/** GsonClass
 * Implementation of GSON methods.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/3/2018 */
public class GsonClass 
{
	/** Converts list of reimbursements to JSON
	 * @param items items to stringify
	 * @return JsonString of reimbursements */
	public static String gsonReimbursements( ArrayList<Reimbursement> items) {
		if (items != null) return gson(items);
		return null;
	}//end gsonReimbursements()
    
	/** Converts list of employees to JSON
	 * @param items items to stringify
	 * @return JsonString of employees */
    public static String gsonEmployees( ArrayList<Employee> items) {
		if (items != null) return gson(items);
    	return null;
	}//end gsonEmployees()

    /** Converts employee to JSON
	 * @param o items to stringify
	 * @return JsonString of employee */
	public static String gsonIndividual(Object o) {
		if (o != null) return gson(o);
		return null;
	}//end gsonIndividual()
	
	/** Stringify's an object.
	 * @param o object to Stringify
	 * @return JSON String */
	private static String gson(Object o) 
	{ return new Gson().toJson(o); }
}//end class GsonInterface
