package exercise_4;

public class OfficeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection connection;
	
	public OfficeDBConnectionBuilder(){
		connection = new DBConnection();
	}
	
	@Override
	public void buildUser() {
		connection.setUser("Soft_Dev");

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
