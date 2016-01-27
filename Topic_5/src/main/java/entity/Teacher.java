package entity;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Version;


@Entity
public class Teacher{
	
	@Id
    @Property("id")
    protected ObjectId id;
 
    @Version
    @Property("version")
    private Long version;
	
	private String first_name;
    private String last_name;
    private Date date_of_birth;
    
    @Reference
    private ArrayList<Course> courses;
    
    public Teacher(){
    	
    }
    
    public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
    
}
