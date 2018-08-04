package utilities;
import java.util.ArrayList;
import com.google.gson.Gson;
import model.Employee;
import model.Reimbursement;

/** GsonClass
 * Implementation for GSON methods.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/3/2018 */
public class GsonClass 
{
	public static String gsonReimbursements( ArrayList<Reimbursement> items) {
		if (items != null) return gson(items);
		return null;
	}//end gsonReimbursements()
    
    public static String gsonEmployees( ArrayList<Employee> items) {
		if (items != null) return gson(items);
    	return null;
	}//end gsonEmployees()

	public static String gsonIndividual(Object o) {
		if (o != null) return gson(o);
		return null;
	}//end gsonIndividual()
	
	/** Turns object into json string */
	private static String gson(Object o) 
	{ return new Gson().toJson(o); }
}//end class GsonInterface
