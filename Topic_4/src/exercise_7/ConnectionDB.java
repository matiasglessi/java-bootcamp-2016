package exercise_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static Connection con;
	private static String url = "jdbc:mysql://127.0.0.1:3306/high-school";
	private static String user = "root";
	private static String pass = "root";

	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		if (con == null) {

			con = DriverManager.getConnection(url, user, pass);
		}
		return con;
	}

}