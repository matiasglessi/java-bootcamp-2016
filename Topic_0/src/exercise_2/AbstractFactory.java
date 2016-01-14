package exercise_2;

import connection.DBConnection;

public abstract class AbstractFactory {
	
	public abstract DBConnection getConnection(String ConnectionType);
}