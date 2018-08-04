package dao_objects;
import dao_interfaces.LoginInterface;
import utilities.Assistant;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/** SignInAccessObject
 * Signs in the users
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class SignInAccessObject implements LoginInterface, Assistant
{
    /** LoginInterface
     * @param username username
     * @param password password
     * @param type the user type */
    @Override
    public boolean login(String username, String password, String type) {
        String sql1 = "{? = call sign_in_employee(?,?) }";
        String sql2 = "{? = call SIGN_IN_MGR(?,?)}";
        String sql = type.equals("EMP") ? sql1 : sql2;
        try {
            if (conn != null) {
                CallableStatement cs = conn.prepareCall(sql);
                cs.registerOutParameter(1, Types.INTEGER);
                cs.setString(2,username);
                cs.setString(3,password);
                cs.executeUpdate();
                int result = cs.getInt(1);
                return result == 1;
            }//end if
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception occurred trying to sign in user. UserID: " + username); }
        return false;
    }//end login()
}//end class SignInAccessObject
