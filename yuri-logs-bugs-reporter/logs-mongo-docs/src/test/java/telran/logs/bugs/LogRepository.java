package telran.logs.bugs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import telran.logs.bugs.mongo.docs.LogDoc;

public  interface LogRepository extends MongoRepository<LogDoc, ObjectId> {
	
}
