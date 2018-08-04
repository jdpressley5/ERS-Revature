package model;
import java.util.Date;

/** Reimbursement (Model)
 * Model for a Reimbursement
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class Reimbursement 
{
    /** Reimbursement ID */
    private int r_id;
    /** The request date */
    private Date requestDate;
    /** The employee ID associated */
    private int employeeID;
    /** The manager ID associated */
    private int managerID;
    /** The message from the employee */
    private String message;
    /** The response Date */
    private Date responseDate;
    /** The response message */
    private String responseMessage;
    /** The amount to reimburse */
    private int amount;
    /** Pending or Resolved*/
    private String status;
    
    //------------------------------------------------------------------------------
	// Constructors
	//------------------------------------------------------------------------------
    
	/** Creates a reimbursement from the DB
	 * @param r_id reimbursementID
	 * @param requestDate request date
	 * @param employeeID employee id
	 * @param managerID manager id
	 * @param message message from employee
	 * @param responseDate response date
	 * @param amount amount
	 * @param status the status of the request
	 * @param responseMessage response message from manager */
	public Reimbursement(int r_id, Date requestDate, int employeeID, int managerID, String message, Date responseDate,
			String responseMessage, String status, int amount) {
		super();
		this.r_id = r_id;
		this.requestDate = requestDate;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.message = message;
		this.responseDate = responseDate;
		this.responseMessage = responseMessage;
		this.status = status;
		this.amount = amount;
    }//end constructor Reimbursement
    
    /** No Args Constructor */
    public Reimbursement(){}
	
	//------------------------------------------------------------------------------
	// Getters
	//------------------------------------------------------------------------------

	/** Gets the status of the reimbursement
	 * @return Status*/
	public String getStatus() { return status; }

	/** Gets amount requested.
	 * @return amount requested */
	public int getAmount() { return amount; }

	/** Gets the Reimbursement ID
	 * @return the r_id  */
	public int getR_id() { return r_id; }

	/** Gets the Request Date
	 * @return the requestDate */
	public Date getRequestDate() { return requestDate; }

	/** Gets the employee ID
	 * @return the employeeID */
	public int getEmployeeID() { return employeeID; }

	/** Gets the manager ID
	 * @return the managerID */
	public int getManagerID() { return managerID; }

	/** Gets the employee message
	 * @return the message */
	public String getMessage() { return message; }

	/** Gets response date
	 * @return the responseDate */
	public Date getResponseDate() { return responseDate; }

	/** Gets the response message
	 * @return the responseMessage */
	public String getResponseMessage() { return responseMessage; }
	
	//------------------------------------------------------------------------------
	// Setters
	//------------------------------------------------------------------------------

	/** Sets the status
	 * @param status status to set*/
	public void setStatus(String status) { this.status = status; }

	/** Sets the ReimbursementID
	 * @param r_id the r_id to set */
	public void setR_id(int r_id) { this.r_id = r_id; }
    
	/** Sets the request Date
	 * @param requestDate the requestDate to set */
	public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
    
	/** Sets the employee ID
	 * @param employeeID the employeeID to set  */
	public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    
	/** Sets the manager ID
	 * @param managerID the managerID to set */
	public void setManagerID(int managerID) { this.managerID = managerID; }
    
	/** Sets the employee message
	 * @param message the message to set */
	public void setMessage(String message) { this.message = message; }
    
	/** Sets response date
	 * @param responseDate the responseDate to set */
	public void setResponseDate(Date responseDate) { this.responseDate = responseDate; }
    
	/** Sets the response message
	 * @param responseMessage the responseMessage to set  */
    public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }

	/** Sets the amount.
	 * @param amt the amount to set */
	public void setAmount(int amt) {this.amount = amt; }
    
    //------------------------------------------------------------------------------
	// Other
	//------------------------------------------------------------------------------
    
    /** Hash code */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + managerID;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + r_id;
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + ((responseDate == null) ? 0 : responseDate.hashCode());
		result = prime * result + ((responseMessage == null) ? 0 : responseMessage.hashCode());
		return result;
	}//end hashCode()
    
    /** Equals */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (employeeID != other.employeeID)
			return false;
		if (managerID != other.managerID)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (r_id != other.r_id)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (responseDate == null) {
			if (other.responseDate != null)
				return false;
		} else if (!responseDate.equals(other.responseDate))
			return false;
		if (responseMessage == null) {
			if (other.responseMessage != null)
				return false;
		} else if (!responseMessage.equals(other.responseMessage))
			return false;
		return true;
	}//end equals()
    
    /** ToString */
	@Override
	public String toString() {
		return r_id + ", requestDate=" + requestDate + ", employeeID=" + employeeID
				+ ", managerID=" + managerID + ", message=" + message + ", responseDate=" + responseDate
				+ ", responseMessage=" + responseMessage + ", amount= " + amount;
	}//end toString()
}//end class Reimbursement
