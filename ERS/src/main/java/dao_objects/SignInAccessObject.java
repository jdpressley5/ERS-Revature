package dao_objects;
import dao_interfaces.LoginInterface;
import servlet.FrontEndServlet;
import utilities.Database;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import org.apache.log4j.Logger;

/** SignInAccessObject
 * Signs in the users
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class SignInAccessObject implements LoginInterface
{
    /** Logging object to record log4j messages.*/
    Logger log = Logger.getLogger(FrontEndServlet.class);
    /** The connection to the database. */
    Connection conn = Database.getConnection();

    /** LoginInterface
     * @param username username
     * @param password password
     * @param type the user type */
    @Override
    public boolean login(String username, String password, String type) {
        String sql1 = "{? = call SIGN_IN_EMP(?,?) }";
        String sql2 = "{? = call SIGN_IN_MGR(?,?)}";
        String sql = type.equals("EMP") ? sql1 : sql2;
        String pass = password;
 
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes(),0,password.length());
			pass = new BigInteger(1,m.digest()).toString(16).toUpperCase();
		}//end try 
		catch (NoSuchAlgorithmException e1) {log.error("MD5 hash missing"); }
		
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
