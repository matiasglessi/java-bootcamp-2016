package exercise_4;

public interface DBConnectionBuilder {

	public void buildUser();
	
	public void buildPass();
	
	public void buildUrl();
	
	public DBConnection getConnection();
}
