package telran.logs.bugs.mongo.docs;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import telran.logs.bugs.dto.LogType;

@Document(collection = "logs")
public class LogDoc {
public LogDoc(Date dateTime, String artifact, int responseTime,
		LogType type, String result) {
		super();
		this.dateTime = dateTime;
		this.artifact = artifact;
		this.responseTime = responseTime;
		this.type = type;
		this.result = result;
	}
Date dateTime;
String artifact;
int responseTime;
LogType type;
String result;
public Date getDateTime() {
	return dateTime;
}
public String getArtifact() {
	return artifact;
}
public int getResponseTime() {
	return responseTime;
}
public LogType getType() {
	return type;
}
public String getResult() {
	return result;
}

}
