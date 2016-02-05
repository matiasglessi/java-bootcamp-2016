package spring.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is a singleton that represents the connection to the database.
 * 
 * @author Matias Glessi
 *
 */
public class DBConnection {

	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/shopping-cart";
	private static String user = "root";
	private static String pass = "root";

	/**
	 * This method obtains the connection.
	 * 
	 * @return The connection to the database.
	 * @throws SQLException
	 *             if a database access error occurs or the url is null
	 * @throws ClassNotFoundException
	 *             if the class could not be located
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		if (con == null) {

			con = DriverManager.getConnection(url, user, pass);
		}
		return con;
	}

}