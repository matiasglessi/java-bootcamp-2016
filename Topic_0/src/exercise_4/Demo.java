package exercise_4;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	
	
	public static void main(String[] args) {
		
		DBConnectionBuilder connectionBuilder = new HomeDBConnectionBuilder();
		DBConnectionDirector connectionDirector = new DBConnectionDirector(connectionBuilder);
		connectionDirector.constructConnection();
		DBConnection conn = connectionDirector.getConnection();
	
		try {
			DriverManager.getConnection(conn.getUrl(), conn.getUser(), conn.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			}

}

