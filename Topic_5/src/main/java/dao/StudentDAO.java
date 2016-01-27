package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import entity.Student;

public class StudentDAO extends BasicDAO<Student, ObjectId> {
    public StudentDAO( Morphia morphia, MongoClient mongo ) {
        super(mongo, morphia, "high-school");
    }
    
    
    public QueryResults<Student> findByCourseApproved(Datastore datastore, int grade, String courseName ) {
    	 Query<Student> query = datastore.createQuery(Student.class);
         query.and(       
           query.criteria("courses.name").equal(courseName),     
           query.criteria("courses.grade").greaterThanOrEq(4)       
         );
         
        return this.find(query);
    }

}
