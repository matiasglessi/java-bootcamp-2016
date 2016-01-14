package exercise_3;

public class DemoProxy {
	
	public static void main(String[] args) {
		ProxyAccesor proxy = new ProxyAccesor("SELECT * FROM Table");
		
		//Connection is not realized.
	    proxy.executeQuery(); 
	    
	      
	    //Connection is realized. Proxy avoids the connection process.
	    proxy.executeQuery();  	
		

	}

}
