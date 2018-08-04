package dao_interfaces;
import model.Employee;
import java.util.ArrayList;

/** PersonInterface
 * This Interface defines methods the person will have.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public interface EmployeeInterface {
	/** Get an employee from the Database */
	Employee getIndividual(int id);
	/** Gets all employees from the Database*/
	ArrayList<Employee> getAllEmployees();
	/** Update employee in the Database */
	void updateEmployee(Employee emp);
	/** Create Employee in the Database */
	void createEmployee(Employee emp);
}//end interface EmployeeInterface
