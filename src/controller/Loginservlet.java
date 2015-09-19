package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import javax.servlet.http.HttpSession;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
    Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 
    	 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
    	
    	 System.out.println("coming here222222222222222222");
    	 String email = request.getParameter("email");
         System.out.println("email   "+email);
         String password = request.getParameter("password");
         System.out.println("password   "+password);
         
        try {
        	System.out.println("coming hereeeeeeeeeeeeee");
        	Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mahash", "root", "root");
            String searchQuery = "SELECT email, password FROM users WHERE email =? AND password =?";
            System.out.println("searchQuery   "+searchQuery);
            
            ps = conn.prepareStatement(searchQuery);
            System.out.println("amrita========>>>   "+searchQuery);
            ps.setString(1, email);
            System.out.println("amrita========>>>   "+email);
            ps.setString(2, password);
            System.out.println("amrita========>>>   "+password);
            //ps.executeQuery();
            rs = ps.executeQuery();
            System.out.println("amrita========>>>   "+searchQuery);
            
            if(rs.next()){
            System.out.println("rs.getString(1)=======>>>   ");
            String checkUser = rs.getString(1);
            System.out.println("in check  "+checkUser);
            String checkPass = rs.getString(2);
            System.out.println("in check  "+checkPass);
            boolean isEmpty = rs.next();
	            /*if((checkUser.equals(email)) && (checkPass.equals(password)))
	            {
	            	*//*System.out.println("in email  "+email);
	            	System.out.println("in password  "+password);
	            	System.out.println("in check");
	            	HttpSession session=request.getSession(); 
	            	System.out.println("session"+session);
	            	session.setAttribute("email",email);
	            	session.setAttribute("password",password);
	            	response.sendRedirect("gripV.jsp");
	            	*/
	            	  if(checkPass.equals(password)){  
	            		    System.out.println("Welcome, "+email);  
	            	        HttpSession session=request.getSession();  
	            	        session.setAttribute("email",email);
	            	        request.getRequestDispatcher("/Profile").forward(request, response);
	            	  }
	            	      else{  
	            		  System.out.println("Sorry, email or password error!");
	            		  
	            		  request.getRequestDispatcher("index.html").include(request, response);
	            		  
	                   }  
	            	} 
	        else{
            	  System.out.println("in email  "+email);
	              System.out.println("in password  "+password);
                  System.out.println("not check");
            	  out.println("<div id=navbar class='wlcmmsg'> Please login first !!</div>");
            	  System.out.println("not check1");
     		      response.sendRedirect("index.html");
     		      System.out.println("not check2");
     		      //out.print("<div class='wlcmmsg'> Please login first !! </div>");
     		      out.println("</div>");
     		      System.out.println("not check3");
     		      
                }
        }
        catch (SQLException e) {
            System.out.println("SQLException occured: " + e.getMessage());
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
        	   System.out.println(e.getMessage());
        	  }
        
        finally {
			try { if (rs != null) rs.close();} 
			catch (SQLException e) { e.printStackTrace(); }
			
			try { if (ps != null) ps.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
			
			try { if (conn != null) conn.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
		}
    }
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
 }

}