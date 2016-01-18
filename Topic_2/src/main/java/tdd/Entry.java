package tdd;

public class Entry {
	
	private String title;
	private String body;
	private String category;
	
	public Entry(String title, String body, String category){
		this.title = title;
		this.body = body;
		this.category = category;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getBody(){
		return this.body;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public void showEntry(){
		System.out.println(title);
	}

}
