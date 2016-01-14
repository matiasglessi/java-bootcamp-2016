package exercise_1;

import connection.DBConnection;
import connection.GenericDBConnection;


public class ConnectionSingleton {
	
	private DBConnection connection;
	
	
	public ConnectionSingleton(){
		this.connection = new GenericDBConnection();
	}


	public DBConnection getConnection(){
		return connection;
	}
	
}	


