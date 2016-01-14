package main;

import exercise_1.ConnectionSingleton;
import exercise_2.AbstractFactory;
import exercise_2.OtherConnectionFactory;
import exercise_2.SpecialConnectionFactory;
import exercise_3.ProxyAccesor;
import exercise_4.DBConnectionBuilder;
import exercise_4.DBConnectionDirector;
import exercise_4.HomeDBConnectionBuilder;

import connection.DBConnection;


public class Main {

	public static void main(String[] args) {
		
		//Exercise 1 - Singleton Pattern
		ConnectionSingleton connectionSingleton = new ConnectionSingleton();
		connectionSingleton.getConnection().connectDB();
		
		// Exercise 2 - Abstract Factory Pattern
		AbstractFactory factory = new SpecialConnectionFactory();
		factory.getConnection("Home").connectDB();
		factory.getConnection("Office").connectDB();
		
		factory = new OtherConnectionFactory();
		factory.getConnection("Generic").connectDB();

		// Exercise 3 - Proxy Pattern
		ProxyAccesor proxy = new ProxyAccesor("SELECT * FROM Table");
		//Connection is not realized.
	    proxy.executeQuery(); 
	    //Connection is realized. Proxy avoids the connection process.
	    proxy.executeQuery();  	
	    
		// Exercise 4 - Pattern
		DBConnectionBuilder connectionBuilder = new HomeDBConnectionBuilder();
		DBConnectionDirector connectionDirector = new DBConnectionDirector(connectionBuilder);
		connectionDirector.constructConnection();
		DBConnection connection = connectionDirector.getConnection();
		connection.connectDB();
	
	}
}
