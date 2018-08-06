package utilities;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;
import servlet.FrontEndServlet;

/** Database
 * Performs the connection to the database. This is a singleton instance
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class Database
{
	/** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(Database.class);
    
    /** static reference to the connection. */
    private static Connection conn = null;

    /** Reads properties file and gets connection to the database.
     * @return Connection object null if error occurred. */
    public static Connection getConnection() {
        if (conn != null) return conn;
        else {
            try{
                Properties props = new Properties();
                props.load(new FileInputStream(
                        "/Users/Josh/Downloads/ERS-Revature/ERS/src/main/resources/oracleDB.properties"));

                Class.forName("oracle.jdbc.driver.OracleDriver");
                String endpoint = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                log.info("connection to Db being made.");
                conn = DriverManager.getConnection(endpoint, username, password);
                return conn;
            }//end try
            catch (Exception e)
            { log.error("Connection to database could not be initialized. - Reason: " + e.getCause()); }
            return null;
        }//end else
    }//end getConnection()

    /** Closes the connection to the Db.*/
    public static void closeConn() {
        try { conn.close(); }
        catch (SQLException e) { log.error("Error occurred closing connection."); }
    }//end closeConn()
}//end class Database
