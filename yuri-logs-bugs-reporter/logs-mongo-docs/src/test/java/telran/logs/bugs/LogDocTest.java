package telran.logs.bugs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import telran.logs.bugs.dto.Log;
import telran.logs.bugs.dto.LogType;
import telran.logs.bugs.mongo.docs.LogDoc;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { LogRepository.class})
@EnableAutoConfiguration


public class LogDocTest {
	
	
@Autowired
LogRepository logs	;
@Test
void logDocTest() {
	Log logDto = new Log(new Date(), LogType.AUTHENTICATION_EXCEPTION,
			"artifact", 20, "result");
	logs.save(new LogDoc(logDto.dateTime, logDto.artifact, logDto.responseTime, logDto.type, logDto.result));
	LogDoc logAct = logs.findAll().get(0);
	Log logDtoAct = new Log(logAct.getDateTime(), logAct.getType(), logAct.getArtifact(),
			logAct.getResponseTime(), logAct.getResult());
	System.out.println(logAct.getDateTime());
	assertEquals(logDto, logDtoAct);
}
 
}
