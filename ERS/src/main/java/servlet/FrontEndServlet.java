package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dispatchers.MasterDispatcher;
import java.io.IOException;

/** FrontEndServlet
 *  Master Servlet for the application
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class FrontEndServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public FrontEndServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 
		response.setContentType("text/html");
		response.getWriter().append(MasterDispatcher.dispatch(request, response)); 
	}//end doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{ 
		response.setContentType("text/html");
		response.getWriter().append(MasterDispatcher.dispatch(request, response)); 
	}//end doPost()
}//end classFrontEndServlet
