package exercise_2;

import connection.DBConnection;
import connection.HomeDBConnection;
import connection.OfficeDBConnection;

public class SpecialConnectionFactory extends AbstractFactory {

	@Override
	public DBConnection getConnection(String ConnectionType) {
			if (ConnectionType.equalsIgnoreCase("Home")) {
				return new HomeDBConnection();
	
			} else if (ConnectionType.equalsIgnoreCase("Office")) {
				return new OfficeDBConnection();
			}
	
			return null;
		}

}
