package exercise_3;

import connection.DBConnection;
import connection.GenericDBConnection;

public class RealAccesor implements Accesor{
	

	private String query;
	private DBConnection dbConnection;
	
	public RealAccesor(String query){
		this.query = query;
		dbConnection = new GenericDBConnection();
		getConnection();
	}
	
	public void getConnection(){
		System.out.println("Getting connection.");
		dbConnection.connectDB();
	
	}
	
	public void executeQuery(){
		System.out.println("Executing query: " + query);
	}


}
