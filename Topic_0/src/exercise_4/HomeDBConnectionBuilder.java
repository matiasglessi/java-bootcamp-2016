package exercise_4;

public class HomeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection conn;
	
	public HomeDBConnectionBuilder(){
		conn = new DBConnection();
	}
	
	@Override
	public void buildUser() {
		conn.setUser("family");

	}

	@Override
	public void buildPass() {
		conn.setPass("123456");

	}

	@Override
	public void buildUrl() {
		conn.setUrl("");
	}

	@Override
	public DBConnection getConnection() {
		return conn;
	}

}
