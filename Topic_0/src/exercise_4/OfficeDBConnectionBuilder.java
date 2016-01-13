package exercise_4;

public class OfficeDBConnectionBuilder implements DBConnectionBuilder {

	private DBConnection conn;
	
	public OfficeDBConnectionBuilder(){
		conn = new DBConnection();
	}
	
	@Override
	public void buildUser() {
		conn.setUser("Soft_Dev");

	}

	@Override
	public void buildPass() {
		conn.setPass("654321");

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
