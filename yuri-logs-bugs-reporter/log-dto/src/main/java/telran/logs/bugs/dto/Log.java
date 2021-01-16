package telran.logs.bugs.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Log {

//@DateTimeFormat(iso = ISO.DATE_TIME)
	@NotNull
public Date dateTime;
@NotNull
	public LogType type;
@NotEmpty
	public String artifact;
	public long responseTime;
	public String result;
	public Log(@NotNull Date dateTime, @NotNull LogType type, @NotEmpty String artifact, long responseTime,
			String result) {
		super();
		this.dateTime = dateTime;
		this.type = type;
		this.artifact = artifact;
		this.responseTime = responseTime;
		this.result = result;
	}
	
	
}
