package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        HttpSession session=request.getSession(false);  
        if(session!=null){  
	        String email=(String)session.getAttribute("email");  
	        out.println("<div id=navbar>");
	        out.print("<div class='wlcmmsg'> Hello, "+email+" Welcome to your profile, these are the members associated with you. </div>");
	        out.println("<a href='LogoutServlet' class='btn-logout' >Logout </a> ");
	        out.println("</div>");
	        
	        request.getRequestDispatcher("gridV.jsp").include(request, response); 
   
	        if (null == email) {
	           request.setAttribute("Error", "Session has ended.  Please login.");
	           RequestDispatcher rd = request.getRequestDispatcher("index.html");
	           rd.forward(request, response);
	           out.println("<div id=navbar>");
			   out.print("<div class='wlcmmsg'> Please login first !! </div>");
			   out.println("</div>");
		        
	       } 
        }  
        else{  
            //out.print("Please login first");  
             request.getRequestDispatcher("index.html").include(request, response); 
			}  
        out.close();  
        
	}
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
