package spring;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class represents the main class of the Shopping Cart application.
 * 
 * @author Matias Glessi
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(Application.class, args);

	}
}
