package model;

/** Employee (Model)
 * Allows access to common objects/methods with implementation of this Interface.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class Employee 
{
	/** The Employee's ID number */
	private int idNumber;
	/** The Employee's first name */
	private String firstName;
	/** The Employee's last name */
	private String lastName;
	/** The Employee's Password */
	private String password;
	/** The Employee's username */
	private String username;
	/** The Address of the user */
	private String address;
	/** The email for the Employee */
	private String email;
	/** The employment status of the employee */
	private String status;

	//------------------------------------------------------------------------------
	// Constructors
	//------------------------------------------------------------------------------
	
	/** Arguements constructor for employee
	 * @param idNumber id number
	 * @param firstName first name
	 * @param lastName last name
	 * @param password password 
	 * @param username username 
	 * @param address address
	 * @param email email */
	public Employee(int idNumber, String firstName, String lastName, 
				String password, String username, String address, String email, String status) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.address = address;
		this.email = email;
		this.status = status;
	}//end constructor Employee

	/** No Args constructor */
	public Employee() {} 
	
	//------------------------------------------------------------------------------
	// Getters
	//------------------------------------------------------------------------------

	/** Gets the status
	 * @return String status */
	public String getStatus() { return this.status; }

    /** Gets the ID Number
     * @return int return the idNumber */
	public int getIdNumber() { return idNumber; }

	/** Gets the Employee's name
     * @return String return the Name */
	public String getName() { return firstName + " " + lastName; }
	
	/** Gets the address
     * @return Address return the address */
	public String getAddress() { return address; }
	
	 /** Gets the password
     * @return String return the password */
	public String getPassword() { return password; }
	
	/** Gets the username
     * @return String return the username */
	public String getUsername() { return username; }
	
	/** Gets the users email
     * @return String return the email */
    public String getEmail() { return email; }
	
	//------------------------------------------------------------------------------
	// Setters
	//------------------------------------------------------------------------------

	/** Sets the ID Number
     * @param idNumber the idNumber to set */
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    /** Sets first name
     * @param firstName the firstName to set */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /** Sets the last name.
     * @param lastName the lastName to set */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /** Sets the password
     * @param password the password to set */
	public void setPassword(String password) { this.password = password; }

    /** Sets the username
     * @param username the username to set */
	public void setUsername(String username) { this.username = username; }
	
    /** Sets the address
     * @param address the address to set */
    public void setAddress(String address) { this.address = address; }

    /** Sets the email
     * @param email the email to set */
	public void setEmail(String email) { this.email = email; }

	/** Sets the status
	 * @param status status */
	public void setStatus(String status) {this.status = status; }
	
	//------------------------------------------------------------------------------
	// Other
	//------------------------------------------------------------------------------

	/** Returns a String of the object */
	@Override
	public String toString() {
		return "idNumber=" + idNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", email=" + email + ", status= " + status;
	}//end toString()

	/** Hash Code */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + idNumber;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}//end hashCode()

	/** Equals Method */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (idNumber != other.idNumber)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
			if (username == null) {
				return other.username == null;
			} else return username.equals(other.username);
	}//end equals()
}//end class Employee
