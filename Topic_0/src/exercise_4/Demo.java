package exercise_4;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	
	
	public static void main(String[] args) {
		
		DBConnectionBuilder connectionBuilder = new HomeDBConnectionBuilder();
		DBConnectionDirector connectionDirector = new DBConnectionDirector(connectionBuilder);
		connectionDirector.constructConnection();
		DBConnection connection = connectionDirector.getConnection();
	
		try {
			DriverManager.getConnection(connection.getUrl(), connection.getUser(), connection.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			}

}

