package dao_objects;
import dao_interfaces.EmployeeInterface;
import model.Employee;
import utilities.Assistant;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** EmployeeAccessObject
 * This is the access object for the employees operations
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/2/2018 */
public class EmployeeAccessObject implements Assistant, EmployeeInterface
{
    //------------------------------------------------------------------------------
    // Singleton
    //------------------------------------------------------------------------------
    /** singleton instance of the class */
    private static EmployeeAccessObject EAO;

    /** No args constructor hidden for singleton use. */
    private EmployeeAccessObject() {}

    /** Gets instance of the class */
    public static EmployeeAccessObject getInstance(){
        if(EAO == null) EAO = new EmployeeAccessObject();
        return EAO;
    }//end getInstance()

    //------------------------------------------------------------------------------
    // Interface Methods
    //------------------------------------------------------------------------------

    /** Get an employee from the Database */
    @Override
    public Employee getIndividual(int id) {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE.STATUS  = 'Active' AND EMPLOYEE.ID = " + id;
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);

                if (!rs.next()) return null;
                else {
                    return new Employee(
                            rs.getInt(1), //id
                            rs.getString(2),//first
                            rs.getString(3),//last
                            rs.getString(5),//password
                            rs.getString(4),//username
                            rs.getString(6),//address
                            rs.getString(7),//email
                            rs.getString(8));//status
                }//end else
            }//end if
        } catch (SQLException e)
        { log.error("SQL Exception getting Pending Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getIndividual()

    /** Gets all employees from the Database */
    @Override
    public ArrayList<Employee> getAllEmployees() {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM EMPLOYEE";
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);

                if (!rs.next()) return null;
                else {
                    ArrayList<Employee> empList = new ArrayList<>();
                    do {
                        empList.add(new Employee(
                                rs.getInt(1), //id
                                rs.getString(2),//first
                                rs.getString(3),//last
                                rs.getString(5),//password
                                rs.getString(4),//username
                                rs.getString(6),//address
                                rs.getString(7),//email
                                rs.getString(8))//status
                        );
                    } while (rs.next());
                }//end else
            }//end if
        } catch (SQLException e)
        { log.error("SQL Exception getting Pending Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getAllEmployees()

    /** Update employee in the Database
     * @param emp Employee to update */
    @Override
    public void updateEmployee(Employee emp) {
        try {
            if (conn != null){
                String sql = "{call UPDATE_EMPLOYEE(?,?,?,?,?,?,?,?)}";
                CallableStatement cs = conn.prepareCall(sql);
                cs.setInt(1, emp.getIdNumber());
                cs.setString(2,emp.getName().substring(0,emp.getName().indexOf(' ')));
                cs.setString(3,emp.getName().substring(emp.getName().indexOf(' ')));
                cs.setString(4,emp.getUsername());
                cs.setString(5,emp.getPassword());
                cs.setString(6,emp.getAddress());
                cs.setString(7,emp.getEmail());
                cs.setString(8,emp.getStatus());
                cs.executeUpdate();
            }//end if
        }//end try
        catch (SQLException sql) { log.error("SQLException occurred in updating employee"); }
    }//end updateEmployee()

    /** Create Employee in the Database
     * @param emp Employee To Add */
    @Override
    public void createEmployee(Employee emp) {
        try {
            if (conn != null){
                String sql = "{call INSERT_EMPLOYEE(?,?,?,?,?,?)}";
                CallableStatement cs = conn.prepareCall(sql);
                cs.setString(1,emp.getName().substring(0,emp.getName().indexOf(' ')));
                cs.setString(2,emp.getName().substring(emp.getName().indexOf(' ')));
                cs.setString(3,emp.getUsername());
                cs.setString(4,emp.getPassword());
                cs.setString(5,emp.getAddress());
                cs.setString(6,emp.getEmail());
                cs.executeUpdate();
            }//end if
        }//end try
        catch (SQLException sql) { log.error("SQLException occurred creating Employee"); }
    }//end createEmployee()
}//end class EmployeeAccessObject
