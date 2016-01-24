package exercise_7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAction {
	
	public DBAction(){
		
	}
	
	// Exercise 7 (Perfor query from exercise 5)
	// For a given teacher, list the timeline for each course that he is assigned to 
	// (ordered by date), 
	// and the course name. The format should be:

	// Teacher: <last-name>, <first-name>
	// Schedule:
	//   Monday 09:00 - 11:00: <course-name>
	//   Monday 15:00 - 17:30: <course-name>
	//   Friday 08:45 - 10:40: <course-name>

	public ResultSet getTeachersSchedule(String teacherName) throws ClassNotFoundException, SQLException{
		Connection con = ConnectionDB.getConnection();
		Statement st = con.createStatement();
		ResultSet rs;
		rs = st.executeQuery( "	SELECT CONCAT(teacher.last_name, ', ',teacher.first_name) AS 'Teacher',"
						 	+ " 	 CONCAT(DAYNAME(course.start_date),' ' ,DATE_FORMAT(course.start_date, '%H:%i'), ' - ', DATE_FORMAT(course.end_date, '%H:%i')) AS 'Schedule',"
						 	+ "      course.name AS 'Course'"
							+ "	FROM course, teacher"
						 	+ " WHERE (course.teacher_name = teacher.last_name) AND (teacher.last_name = '"
							+ teacherName
							+"')"
							+ " ORDER BY DAYNAME(course.start_date);");
		this.printQuery(rs);
		return rs;
	}

	
	public void printQuery(ResultSet rs) throws SQLException{
		ResultSetMetaData rsmd = rs.getMetaData();
	    if(rs.next()){
	    	System.out.println("Teacher: " + rs.getString(1));
	    	System.out.println("Schedule: ");
	    }
	    rs.beforeFirst();
	    int columnsNumber = rsmd.getColumnCount();
	    while (rs.next()) {
	        for (int i = 2; i <= columnsNumber; i++) {
	            String columnValue = rs.getString(i);
	            System.out.print("	"+columnValue);
	        }
	        System.out.println("");
	    }
	}
}
