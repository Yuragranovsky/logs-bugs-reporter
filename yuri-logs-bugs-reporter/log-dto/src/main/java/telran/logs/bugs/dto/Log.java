package telran.logs.bugs.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Log {

@DateTimeFormat(iso = ISO.DATE_TIME)
	@NotNull
public Date dateTime;
@NotNull
	public LogType type;
@NotEmpty
	public String artifact;
	public int responseTime;
	public String result;
	public Log(@NotNull Date dateTime, @NotNull LogType type, @NotEmpty String artifact, int responseTime,
			String result) {
		super();
		this.dateTime = dateTime;
		this.type = type;
		this.artifact = artifact;
		this.responseTime = responseTime;
		this.result = result;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artifact == null) ? 0 : artifact.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + (int) (responseTime ^ (responseTime >>> 32));
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (artifact == null) {
			if (other.artifact != null)
				return false;
		} else if (!artifact.equals(other.artifact))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (responseTime != other.responseTime)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
