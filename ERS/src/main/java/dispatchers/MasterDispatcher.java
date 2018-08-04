package dispatchers;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.Assistant;

/** MasterDispatcher
 * Dispatcher that distributes to the appropriate dispatchers.
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/30/2018 */
public class MasterDispatcher implements Assistant
{	
	public static void dispatch(HttpServletRequest request, HttpServletResponse response) 
	{
		try {
			switch (request.getRequestURI()){
				case "loginE.do": //employee home
					boolean res = EmployeeDispatcher.signIn(request.getParameter("username"),request.getParameter("password")); 
					if(res) response.getWriter().append("http://localhost:8080/ERS/HTML/Employee/EHome.html");
					break; 
				case "loginM.do": //manager home
					res = ManagerDispatcher.signIn(request.getParameter("username"),request.getParameter("password")); 
					if(res) response.getWriter().append("http://localhost:8080/ERS/HTML/Manager/MHome.html");
					break; 
				case "3": break; //create reimbursement
				case "2": break; //view reimbursement
				case "5": break; //view reimbursements
				case "4": break; //view employees
				case "6": break; //logout
				case "7": break; //view an employee
				case "8": break; //update user info
				default: //page not found
			}//end switch
		} catch (IOException ioe) {log.error("IOException occurred when writing out");}
	}//end dispatch()
}//end class MasterDispatcher
