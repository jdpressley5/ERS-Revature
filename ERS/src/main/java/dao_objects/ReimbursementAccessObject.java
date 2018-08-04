package dao_objects;
import dao_interfaces.ReimbursementInterface;
import model.Reimbursement;
import servlet.FrontEndServlet;
import utilities.Database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/** ReimbursementAccessObject
 * This is the access object for the reimbursements operations
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 8/2/2018 */
public class ReimbursementAccessObject implements ReimbursementInterface
{
    /** Logging object to record log4j messages.*/
    static Logger log = Logger.getLogger(FrontEndServlet.class);
    /** The connection to the database. */
    Connection conn = Database.getConnection();
    
    //------------------------------------------------------------------------------
    // Singleton
    //------------------------------------------------------------------------------
    /** singleton instance of the class */
    private static ReimbursementAccessObject RAO;
    /** No args constructor hidden for singleton access */
    private ReimbursementAccessObject() {}

    /** Gets instance of the class */
    public static ReimbursementAccessObject getInstance(){
        if(RAO == null) RAO = new ReimbursementAccessObject();
        return RAO;
    }//end getInstance()

    //------------------------------------------------------------------------------
    // Interface Methods
    //------------------------------------------------------------------------------

    /** Create a Reimbursement
     * @param re reimbursement to add */
    @Override
    public void createReimbursement(Reimbursement re) {
        try {
            if (conn != null){
                String sql = "{call INSERT_REIMBURSEMENT_EMPLOYEE(?,?,?)}";
                CallableStatement cs = conn.prepareCall(sql);
                cs.setString(1,re.getMessage());
                cs.setInt(2,re.getEmployeeID());
                cs.setInt(3,re.getAmount());
                cs.executeUpdate();
            }//end if
        }//end try
        catch (SQLException sql) { log.error("SQLException occurred in U-createUser()"); }
    }//end createReimbursement()

    /** Look up a specific reimbursement
     * @param reimbNumber id to look up */
    @Override
    public Reimbursement getAReimbursement(int reimbNumber) {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENTS.R_ID = "+ reimbNumber;
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);
                if (!rs.next()) return null;
                else {
                    return new Reimbursement(
                            rs.getInt(1), //rID
                            rs.getDate(2),//request date
                            rs.getInt(3),//employee id
                            rs.getInt(4), //manager id
                            rs.getString(5),//request message
                            rs.getDate(6), // response date
                            rs.getString(7), //response message
                            rs.getString(8), //status
                            rs.getInt(9)); //amount
                }//end else
            }//end if
        } catch (SQLException e)
        { log.error("SQL Exception getting Resolved Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getAReimbursement()

    /** Look up all resolved reimbursements */
    @Override
    public ArrayList<Reimbursement> getResolvedReimbursements() {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENTS.STATUS  = 'Resolved'";
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);
                return generateArrayList(rs);
            }//end if
        } catch (SQLException e)
        { log.error("SQL Exception getting Resolved Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getResolvedReimbursements()

    /** Gets all pending Reimbursements */
    @Override
    public ArrayList<Reimbursement> getPendingReimbursements() {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENTS.STATUS  = 'Pending'";
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);
                return generateArrayList(rs);
            }//end if
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception getting Pending Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getPendingReimbursements()

    /** Approve or deny response in Database
     * @param approve decision
     * @param reply reply message
     * @param re reimbursement to change */
    @Override
    public void approveDenyRequest(boolean approve, String reply, Reimbursement re) {
        try {
            if (conn != null){
                String sql = "{call REPLY_REIMBURSEMENT(?,?,?)}";
                String decision= approve ? "Approved" : "Declined";
                CallableStatement cs = conn.prepareCall(sql);
                cs.setString(1,reply);
                cs.setString(2,decision);
                cs.setInt(3, re.getR_id());
                cs.executeUpdate();
            }//end if
        }//end try
        catch (SQLException sql) { log.error("SQLException occurred in U-createUser()"); }
    }//end approveDenRequest()

    /** Gets pending for a specific user
     * @param EID employee id number */
    @Override
    public ArrayList<Reimbursement> getFilterPendingReimbursements(int EID) {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM REIMBURSEMENTS" +
                        " WHERE REIMBURSEMENTS.STATUS  = 'Pending' AND REIMBURSEMENTS.EMPLOYEE = " + EID;
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);
                return generateArrayList(rs);
            }//end if
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception getting FILTERED Pending Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getFilterPendingReimbursements()

    /** Gets Resolved for a specific user
     * @param EID Employee id number*/
    @Override
    public ArrayList<Reimbursement> getFilterResolvedReimbursements(int EID) {
        try {
            if (conn != null) {
                String sql = "SELECT * FROM REIMBURSEMENTS" +
                        " WHERE REIMBURSEMENTS.STATUS  = 'Resolved' AND REIMBURSEMENTS.EMPLOYEE = " + EID;
                Statement cs = conn.prepareCall(sql);
                ResultSet rs = cs.executeQuery(sql);
                return generateArrayList(rs);
            }//end if
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception getting FILTERED Resolved Reimbursements). REASON: " + e.getMessage()); }
        return null;
    }//end getFilterResolvedReimbursements()

    /** Upload an image into Database */
    @Override
    public void uploadImage() { log.error("Upload Image is an unsupported operation"); } //TODO last

    //------------------------------------------------------------------------------
    // Helper Methods
    //------------------------------------------------------------------------------

    /** Generates an arraylist of reimbursements
     * @param rs the result set to go through.
     * @return ArrayList of Reimbursements*/
    private static ArrayList<Reimbursement> generateArrayList(ResultSet rs) {
        try{
            if (!rs.next()) return null;
            else {
                ArrayList<Reimbursement> listReimb = new ArrayList<>();
                do {
                    listReimb.add(new Reimbursement(
                                    rs.getInt(1), //rID
                                    rs.getDate(2),//request date
                                    rs.getInt(3),//employee id
                                    rs.getInt(4), //manager id
                                    rs.getString(5),//request message
                                    rs.getDate(6), // response date
                                    rs.getString(7), //response message
                                    rs.getString(8), //status
                                    rs.getInt(9)) //amount
                    );
                }while(rs.next());
                return listReimb;
            }//end else
        }//end try
        catch (SQLException e)
        { log.error("SQL Exception getting Reimbursements from Result Set). REASON: " + e.getMessage()); }
        return null;
    }//end generateArrayList()
}//end class ReimbursementAccessObject
