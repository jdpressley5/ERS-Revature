package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dispatchers.MasterDispatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/** FrontEndServlet
 *  Master Servlet for the application
 *
 * --Revature Project 1 --
 * @author Joshua Pressley
 * @version 1.0 7/27/2018 */
public class FrontEndServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static Map<String,String> params;
       
    public FrontEndServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{ 		
		BufferedReader br = request.getReader();
		Type type = new TypeToken<Map<String,String>>(){}.getType();
		params = new Gson().fromJson(br.readLine(), type);	

		response.setContentType("text/html");
		response.getWriter().append(MasterDispatcher.dispatch(request, response, params)); 
	}//end doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{ 
		BufferedReader br = request.getReader();
		Type type = new TypeToken<Map<String,String>>(){}.getType();
		params = new Gson().fromJson(br.readLine(), type);	
		
		response.setContentType("text/html");
		response.getWriter().append(MasterDispatcher.dispatch(request, response, params)); 
	}//end doPost()
}//end classFrontEndServlet
