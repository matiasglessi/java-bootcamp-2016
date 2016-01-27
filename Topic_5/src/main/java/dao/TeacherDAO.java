package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import entity.Teacher;

public class TeacherDAO extends BasicDAO<Teacher, ObjectId> {
    public TeacherDAO( Morphia morphia, MongoClient mongo ) {
        super(mongo, morphia, "high-school");
    }
    
}
