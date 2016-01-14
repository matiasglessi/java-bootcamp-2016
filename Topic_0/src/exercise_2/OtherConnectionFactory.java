package exercise_2;

import connection.DBConnection;
import connection.GenericDBConnection;

public class OtherConnectionFactory extends AbstractFactory {

	@Override
	public DBConnection getConnection(String ConnectionType) {
		if (ConnectionType.equalsIgnoreCase("Generic")) {
			return new GenericDBConnection();
		}	
		return null;
	}
}
