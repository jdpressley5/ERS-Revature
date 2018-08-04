package servlet;
import utilities.Assistant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** FrontEndServlet
 *  Master Servlet for the application
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class FrontEndServlet extends HttpServlet implements Assistant
{
	private static final long serialVersionUID = 1L;
       
    public FrontEndServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}//end doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}//end doPost()

}//end classFrontEndServlet
