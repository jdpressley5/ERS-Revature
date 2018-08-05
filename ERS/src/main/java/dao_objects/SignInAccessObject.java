package dao_objects;
import dao_interfaces.LoginInterface;
import servlet.FrontEndServlet;
import utilities.Database;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    Logger log = Logger.getLogger(SignInAccessObject.class);
    /** The connection to the database. */
    Connection conn = Database.getConnection();

    /** LoginInterface
     * @param username username
     * @param password password
     * @param type the user type */
    @Override
    public boolean login(String username, String password, String type) {
    	String pass = password;
    	try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes(),0,password.length());
			pass = new BigInteger(1,m.digest()).toString(16).toUpperCase();
			
		}//end try 
		catch (NoSuchAlgorithmException e1) {log.error("MD5 hash missing"); }
    	
        String sql1 = "SELECT COUNT(username) FROM Employee WHERE username=" + username + " AND password="+ pass;
        String sql2 = "SELECT password FROM Manager WHERE username = \'" + username + "\'";
        String sql = type.equals("EMP") ? sql1 : sql2;
        System.out.println(sql);
        
        try {
            if (conn != null) {
            	Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String result = rs.getString(1);
                System.out.println("result: " + result);
                System.out.println("pass: " + pass);
                return result.equals(pass);
            }//end if
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception occurred trying to sign in user. UserID: " + username);
        	e.printStackTrace(); }
        return false;
    }//end login()
}//end class SignInAccessObject
