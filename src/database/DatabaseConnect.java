package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnect {
	
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {                                                                                                                                                         
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
			try {
			String connectionUrl = "jdbc:mysql://localhost:3306/Mahash";
			String connectionUser = "root";
			String connectionPassword = "root";
			
			connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}
			/*finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
				try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
			}*/
		return connection;
	}
}
}
