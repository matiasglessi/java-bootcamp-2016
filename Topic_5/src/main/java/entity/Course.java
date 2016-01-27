package entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;

@Entity
public class Course{

	@Id
    @Property("id")
	protected String course_name;
 
    @Version
    @Property("version")
    private Long version;
	
	private int hours_by_week;
	private Date start_date;
	private Date end_date;
	
	  
	public Course(){
		
	}

	public String getName() {
		return course_name;
	}

	public void setName(String name) {
		this.course_name = name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getHours_by_week() {
		return hours_by_week;
	}

	public void setHours_by_week(int hours_by_week) {
		this.hours_by_week = hours_by_week;
	}
	
	
}
