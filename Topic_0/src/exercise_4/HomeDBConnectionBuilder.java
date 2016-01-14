package exercise_4;

import connection.DBConnection;
import connection.HomeDBConnection;

public class HomeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection connection;
	
	public HomeDBConnectionBuilder(){
		connection = new HomeDBConnection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("family");

	}

	@Override
	public void buildPass() {
		connection.setPass("123456");

	}

	@Override
	public void buildUrl() {
		connection.setUrl("");
	}

	public DBConnection getConnection() {
		return connection;
	}

}
