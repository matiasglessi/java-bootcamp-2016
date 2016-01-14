package exercise_3;

public class ProxyAccesor implements Accesor{
	
	private String query;
	private RealAccesor accesor;
	
	public ProxyAccesor(String query){
		this.query = query;
	}
	
	public void executeQuery(){
		if (accesor == null){
			accesor = new RealAccesor(query);
		}
	accesor.executeQuery();
	}

}
