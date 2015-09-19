package controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.User;
import database.DatabaseConnect;

public class Crud {
	
	private Connection dbConnection;
	private PreparedStatement pStmt;

	public Crud() {
		 System.out.println("hello");
		 dbConnection = DatabaseConnect.getConnection();
		 System.out.println("connected");
	}
   
	public void addUser(User user) {
		  //String insertQuery = "insert into users (id,firstName,lastName,country,state,gender,address,username,email,password) values(?,?,?,?,?,?,?,?,?,?)";
		  String insertQuery = "insert into users (firstName,lastName,gender, country, state,address,email) values(?,?,?,?,?,?,?)";
		try {
			pStmt = dbConnection.prepareStatement(insertQuery);
			//pStmt.setInt(1, user.getId());
			pStmt.setString(1, user.getfirstname());
			pStmt.setString(2, user.getlastname());
			pStmt.setString(5, user.getgender("optionsRadios"));
			pStmt.setString(3, user.getcountry());
			pStmt.setString(4, user.getstate());
			pStmt.setString(5, user.getaddress());
			pStmt.setString(6, user.getemail());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void deleteUser(int id) {
		System.out.println("I am delete");
		System.out.println("id  "+id);
		String deleteQuery = "DELETE FROM users WHERE id = ?";
		try {
			pStmt = dbConnection.prepareStatement(deleteQuery);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public void updateUser(User user)  {
		System.out.println("I am update");
		String updateQuery = "UPDATE users SET firstname = ?, " +
				"lastname = ?, email = ? WHERE id = ?";
		try {
			pStmt = dbConnection.prepareStatement(updateQuery);		
			pStmt.setString(1, user.getfirstname());
			pStmt.setString(2, user.getlastname());
			pStmt.setString(3, user.getemail());
			pStmt.setInt(4, user.getId());
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public List<User> getAllUsers() {
		System.out.println("coming here all userssssssssss");
		List<User> users = new ArrayList<User>();

		String query = "SELECT id, firstname, lastname,gender,country, state,address, email FROM users";
		try {
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("rs=====>>>>   "+rs);
			System.out.println("query=====>>>>   "+query);
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setfirstname(rs.getString("firstName"));
				user.setlastname(rs.getString("lastName"));
				user.setgender(rs.getString("gender"));
				user.setcountry(rs.getString("country"));
				user.setstate(rs.getString("state"));
				user.setaddress(rs.getString("address"));
				user.setemail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	return users;
	}
	
	
	
	
}
