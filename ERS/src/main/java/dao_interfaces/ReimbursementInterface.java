package dao_interfaces;
import model.Reimbursement;
import java.util.ArrayList;

/** ReimbursementInterface
 * This Interface defines methods the reimbursement will have.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/31/2018 */
public interface ReimbursementInterface
{
	/** Create a Reimbursement*/
	void createReimbursement(Reimbursement re);
	/** Look up a specific reimbursement */
	Reimbursement getAReimbursement(int reimbNumber);
	/** Look up all resolved reimbursements */
	ArrayList<Reimbursement> getResolvedReimbursements();
	/** Gets all pending Reimbursements */
    ArrayList<Reimbursement>  getPendingReimbursements();
	/** Approve or deny response in Database */
	void approveDenyRequest(boolean approve, String reply, Reimbursement re);
	/** Gets pending for a specific user */
    ArrayList<Reimbursement> getFilterPendingReimbursements(int EID);
	/** Gets Resolved for a specific user */
    ArrayList<Reimbursement> getFilterResolvedReimbursements(int EID);
}//end interface ReimbursementInterface
