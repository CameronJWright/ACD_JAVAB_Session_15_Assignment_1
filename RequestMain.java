package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestMain
 */
@WebServlet("/RequestMain")
public class RequestMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String type;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>THIS IS INCLUDED</h1>");
		
		out.println("<form action=\"RequestMain\" method=\"post\">\r\n" + 
				"			<input type=\"submit\" name=\"type\" value=\"Include\"> \r\n" + 
				"			<input type=\"submit\" name=\"type\" value=\"Forward\"> \r\n" + 
				"		</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		RequestDispatcher rd= request.getRequestDispatcher("Header");
		
		type=request.getParameter("type");
		if(type.equals("Include"))
			rd.include(request, response);
		else if(type.equals("Forward"))
			rd.forward(request, response);
			
	}

}
