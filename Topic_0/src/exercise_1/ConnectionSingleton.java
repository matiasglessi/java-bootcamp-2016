package exercise_1;

import java.sql.DriverManager;
import java.sql.SQLException;

import connection.DBConnection;



public class ConnectionSingleton extends DBConnection{
	
	private static ConnectionSingleton connection;
		
	
	public ConnectionSingleton(){
	}


	public static ConnectionSingleton getInstance() {
		if (connection == null) {
			connection = new ConnectionSingleton();
		}
		return connection;
	}


	@Override
	public void connectDB() {
		System.out.println("Getting connection...");
		
		try {
			DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
	
	
		


