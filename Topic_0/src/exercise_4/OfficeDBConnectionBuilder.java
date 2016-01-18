package exercise_4;

import connection.DBConnection;
import connection.OfficeDBConnection;

public class OfficeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection connection;
	
	public OfficeDBConnectionBuilder(){
		connection = new OfficeDBConnection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("soft_dev");

	}

	@Override
	public void buildPass() {
		connection.setPass("654321");

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
