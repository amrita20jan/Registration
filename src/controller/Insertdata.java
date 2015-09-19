package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertdata")
@SuppressWarnings("serial")
public class Insertdata extends HttpServlet{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
			response.setContentType("text/html;charset=UTF-8");  
			PrintWriter out = response.getWriter();  
			
			try {System.out.println("test");
//				new com.mysql.jdbc.Driver();
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				System.out.println("test1111");
	// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
				String connectionUrl = "jdbc:mysql://localhost:3306/Mahash";
				String connectionUser = "root";
				String connectionPassword = "root";
				
				conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				//prepstmt = conn.createStatement();
				
			   //rs = stmt.executeQuery("SELECT * FROM users");
			   //rs = stmt.executeQuery("insert into users(id,firstName,lastName,country,state,gender,address,username,email,password,confirm_password) values('"+t+"','"+n+"','"+cn+"','"+pos+"','"+req+"','"+eid+"',"+ph1+","+ph2+")");
				
				String sqlInsert="insert into users (firstName,lastName,country,state,gender,address,username,email,password) values(?,?,?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sqlInsert);
			
				
				//ps.setString(0,request.getParameter("id"));
				ps.setString(1, request.getParameter("firstname"));
				System.out.println(request.getParameter("firstname"));
				ps.setString(2, request.getParameter("lastname"));
				ps.setString(3,request.getParameter("country"));
				ps.setString(4,request.getParameter("state"));
				ps.setString(5, request.getParameter("optionsRadios"));
				ps.setString(6, request.getParameter("address"));
				ps.setString(7,request.getParameter("username"));
				ps.setString(8, request.getParameter("email"));
				ps.setString(9, request.getParameter("password"));
				//ps.setString(10, request.getParameter("confirm_password"));
				int n = ps.executeUpdate();
				System.out.println("value of n ====>>>>  "+n);
			
				
				rs = ps.executeQuery("SELECT * FROM users");
				
				while (rs.next()) {
				
					int id = rs.getInt("id");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String country = rs.getString("country");
					String state = rs.getString("state");
					String gender = rs.getString("gender");
					String address = rs.getString("address");
					String username = rs.getString("username");
					String email = rs.getString("email");
					String password = rs.getString("password");
					//String confirm_password = rs.getString("confirm_password");
					
					System.out.println("ID: " + id);
					System.out.println("firstName: " + firstName);
					System.out.println("lastName: " + lastName);
					System.out.println("country: " + country);
					System.out.println("state: " + state);
					System.out.println("gender: " + gender);
					System.out.println("address: " + address);
					System.out.println("username: " + username);
					System.out.println("email: " + email);
					System.out.println("password: " + password);
					//System.out.println("confirm_password: " + confirm_password);
							
				}
				request.getRequestDispatcher("index.html").include(request, response);
				 out.println("<div id=navbar>");
			     out.print("<div class='wlcmmsg'> You are successfully registered, now U can Login and get in :) !! </div>");
				 out.println("</div>");
		        
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { if (rs != null) rs.close();} 
				catch (SQLException e) { e.printStackTrace(); }
				
				try { if (ps != null) ps.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
				
				try { if (conn != null) conn.close(); } 
				catch (SQLException e) { e.printStackTrace(); }
				
			}
		}
	
	@Override  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	throws ServletException, IOException {  
	processRequest(request, response);  
	}  


	@Override  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	throws ServletException, IOException {  
	processRequest(request, response);  
	}  


	@Override  
	public String getServletInfo() {  
	return "Short description";  
	}  
}  
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			

    
