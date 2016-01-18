package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDBConnection extends DBConnection {

	@Override
	public void connectDB() {
		System.out.println("Getting generic connection...");
		
		try {
			DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
