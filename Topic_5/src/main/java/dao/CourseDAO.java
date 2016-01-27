package dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import entity.Course;

public class CourseDAO extends BasicDAO<Course, ObjectId> {
    public CourseDAO( Morphia morphia, MongoClient mongo ) {
        super(mongo, morphia, "high-school");
    }
}
