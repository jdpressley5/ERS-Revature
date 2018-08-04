package model;

/** Manager (Model)
 * Model for the Manager
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class Manager 
{
    /** ID number */
    private int idNumber;
    /** First name */
    private String firstName;
    /** Last Name */
    private String lastName;
    /** The Username */
    private String username;
    /** Password */
    private String password;
    /** The Address */
    private String address;
    /** The email */
    private String email;
    
	//------------------------------------------------------------------------------
	// Constructors
	//------------------------------------------------------------------------------
    
	/** Arguements constructor
	 * @param idNumber id number
	 * @param firstName first name
	 * @param lastName last name 
	 * @param username username
	 * @param password password
	 * @param address address
	 * @param email email */
	public Manager(int idNumber, String firstName, String lastName, String username, 
					String password, String address, String email) {
		super();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
	}//end constructor Manager
	
	/** No Args Constructor */
	public Manager() {}

	//------------------------------------------------------------------------------
	// Getters
	//------------------------------------------------------------------------------

	/** Gets the ID number
	 * @return the idNumber */
	public int getIdNumber() { return idNumber; }

	/** Gets the Manager's name
     * @return String return the Name */
	public String getName() { return firstName + " " + lastName; }

	/** Gets the username
	 * @return the username */
	public String getUsername() { return username; }

	/** Gets the password
	 * @return the password */
	public String getPassword() { return password; }

	/** Gets the address
	 * @return the address */
	public String getAddress() { return address; }

	/** Gets the email
	 * @return the email */
	public String getEmail() { return email; }

	//------------------------------------------------------------------------------
	// Setters
	//------------------------------------------------------------------------------
        
	/** Sets the ID number
	 * @param idNumber the idNumber to set */
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }
    
	/** Sets the first name
	 * @param firstName the firstName to set */
	public void setFirstName(String firstName) { this.firstName = firstName; }

	/** Sets the last name
	 * @param lastName the lastName to set */
	public void setLastName(String lastName) { this.lastName = lastName; }
    
	/** Sets the username
	 * @param username the username to set */
	public void setUsername(String username) { this.username = username; }
    
	/** Sets the password
	 * @param password the password to set  */
	public void setPassword(String password) { this.password = password; }
    
	/** Sets the address
	 * @param address the address to set */
	public void setAddress(String address) { this.address = address; }
    
	/** Sets email
	 * @param email the email to set */
	public void setEmail(String email) { this.email = email; }
	
	//------------------------------------------------------------------------------
	// Other
	//------------------------------------------------------------------------------
	
	/** Hashcode */
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
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Manager other = (Manager) obj;
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
    
    /** ToString */
	@Override
	public String toString() {
		return "Manager [idNumber=" + idNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", address=" + address + ", email=" + email + "]";
	}//end toString()
}//end class Manager
