package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	
	private Crud c;

	public Controller() {
		c = new Crud();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		List<User> userList = new ArrayList<User>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");

		if (action != null) {
			try {
				System.out.println("coming here6666666666666666");
				if (action.equals("list")) {
					System.out.println("test");
					userList = c.getAllUsers();

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Records", userList);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);

					response.getWriter().print(jsonArray);
				  } 
				
				else if (action.equals("create") || action.equals("update") || (action.equals("delete"))) {
					User user = new User();
					
					if (request.getParameter("id") != null) {
						System.out.println("userID------ >>>>>>>    "+request.getParameter("id"));
						int id = Integer.parseInt(request.getParameter("id"));
						user.setId(id);
					}

					if (request.getParameter("firstname") != null) {
						System.out.println("firstname------ >>>>>>>    "+request.getParameter("firstname"));
						String firstname = request.getParameter("firstname");
						user.setfirstname(firstname);
					}

					if (request.getParameter("lastname") != null) {
						String lastname = request.getParameter("lastname");
						user.setlastname(lastname);
					}

					if (request.getParameter("email") != null) {
						String email = request.getParameter("email");
						user.setemail(email);
					}

					if (action.equals("create")) {
						// Create new record
						c.addUser(user);
					} else if (action.equals("update")) {
						// Update existing record
						c.updateUser(user);
					}

					// Return in the format required by jTable plugin
					JSONROOT.put("Result", "OK");
					JSONROOT.put("Record", user);

					// Convert Java Object to Json
					String jsonArray = gson.toJson(JSONROOT);
					response.getWriter().print(jsonArray);
				} 
				
				/*else if (action.equals("delete")) {
					User user = new User();
					
				String userid = request.getParameter("id");
					System.out.println("userID------ >>>>>>>    "+userid+" action==>>>>  "+action.equals("delete"));
					// Delete record
					if (request.getParameter("userid") != null) {
						int id = Integer.parseInt(request.getParameter("userid"));
						c.deleteUser(id);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
				}*/
			} catch (Exception ex) {
				JSONROOT.put("Result", "ERROR");
				JSONROOT.put("Message", ex.getMessage());
				String error = gson.toJson(JSONROOT);
				response.getWriter().print(error);
			}
		}
	}
}