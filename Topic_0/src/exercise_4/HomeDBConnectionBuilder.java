package exercise_4;

public class HomeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection connection;
	
	public HomeDBConnectionBuilder(){
		connection = new DBConnection();
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

	@Override
	public DBConnection getConnection() {
		return connection;
	}

}
