package entity;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class CourseAttended {
	
	@Reference
	private Course course;
	private String name;
	private int grade;
	
	public CourseAttended(Course course, String name, int grade){
		this.name = name;
		this.grade = grade;
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}


}
