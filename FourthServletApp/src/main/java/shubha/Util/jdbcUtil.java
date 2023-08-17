package shubha.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcUtil {
	
	static {
		
		// load and register the driver
		
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getDbConnection() throws SQLException {
		
		// Establish the Connection
		
		String url = "jdbc:mysql://localhost:3306/shubha";
		String user = "root";
		String password = "1234";

		return  DriverManager.getConnection(url, user,password);
	}
	
	public static void closeResources(ResultSet resultSet,Statement statement,Connection connection) throws SQLException {
		
		//Connection close    ---------This is an Block of Code------------
		
		if(resultSet!=null)
			resultSet.close();
		
		if(statement!=null)
			statement.close();
		
		if(connection!=null)
			connection.close();
	}
}
