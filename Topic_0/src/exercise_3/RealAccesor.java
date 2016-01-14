package exercise_3;

import java.sql.DriverManager;
import java.sql.SQLException;

public class RealAccesor implements Accesor{
	
	private String serverName;
	private String dbms;
	private String portNumber;
	private String query;
	
	public RealAccesor(String query){
		//...
		this.query = query;
	}
	
	public void getConnection(){
		try {
			DriverManager.getConnection("jdbc:" + this.dbms + "://" +this.serverName +":" + this.portNumber + "/","user", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeQuery(){
		//...
	}


}
