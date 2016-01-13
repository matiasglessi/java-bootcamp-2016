package exercise_4;

public class DBConnectionDirector {

	private DBConnectionBuilder connectionBuilder = null;
	
	public DBConnectionDirector (DBConnectionBuilder connectionBuilder){
		this.connectionBuilder = connectionBuilder;
	}
	
	public void constructConnection(){
		connectionBuilder.buildUser();
		connectionBuilder.buildPass();
		connectionBuilder.buildUrl();
	}
	
	public DBConnection getConnection(){
		return connectionBuilder.getConnection();
	}
}
