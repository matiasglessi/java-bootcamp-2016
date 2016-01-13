package exercise_3;

public class ProxyAccesor implements Accesor{
	
	private String query;
	private RealAccesor accesor;
	
	public ProxyAccesor(String q){
		this.query = q;
	}
	
	public void executeQuery(){
		if (accesor == null){
			accesor = new RealAccesor(query);
		}
	accesor.executeQuery();
	}

}
