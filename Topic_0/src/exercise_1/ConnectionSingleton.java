package exercise_1;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSingleton {
	
	private String serverName;
	private String dbms;
	private String portNumber;
	
	public ConnectionSingleton(){
	}

	public void getConnection(){
		try {
			DriverManager.getConnection("jdbc:" + this.dbms + "://" +this.serverName +":" + this.portNumber + "/","user", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
