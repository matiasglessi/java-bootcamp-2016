package exercise_4;

import connection.DBConnection;
import connection.GenericDBConnection;

public class GenericDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection connection;
	
	public GenericDBConnectionBuilder(){
		connection = new GenericDBConnection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("admin");

	}

	@Override
	public void buildPass() {
		connection.setPass("admin");

	}

	@Override
	public void buildUrl() {
		connection.setUrl("");
	}

	@Override
	public DBConnection getConnection() {
		return connection;
	}

}

