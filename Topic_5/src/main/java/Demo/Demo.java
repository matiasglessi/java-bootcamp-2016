package Demo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import dao.StudentDAO;
import entity.Student;


public class Demo 
{
    public static void main( String[] args )
    {
    	
    	//Connect to Database
    	String dbName = new String("high-school");
        MongoClient mongoClient = new MongoClient();
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongoClient, dbName);   
        
        morphia.mapPackage("entity");
    	
    	StudentDAO studentDAO = new StudentDAO(morphia, mongoClient);
    
    	//Exercise 2:Fetch all students whose notes in a specific course were greater than 4.
    	QueryResults<Student> retrievedStudents = studentDAO.findByCourseApproved(datastore, 4, "TDD");
    	
    	   
        for (Student retrievedStudent : retrievedStudents) {
            System.out.println(retrievedStudent.getFirst_name());
            System.out.println(retrievedStudent.getLast_name());
            studentDAO.delete(retrievedStudent);
        } 
    	
    	mongoClient.close();
        
    }
}
