package entities;

public class User {
	
	private String name;
	private String pass;
	private int id;
	
	public User (String name, String pass, int id){
		this.name = name;
		this.pass = pass;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
