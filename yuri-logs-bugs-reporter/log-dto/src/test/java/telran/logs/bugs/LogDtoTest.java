package telran.logs.bugs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.logs.bugs.dto.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(LogDtoTest.TestController.class)
@ContextConfiguration(classes= LogDtoTest.TestController.class)
@AutoConfigureMockMvc
public class LogDtoTest {
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	MockMvc mock;
	public static @RestController
	class TestController {
		@PostMapping("/")
		void dtoTest(@RequestBody @Valid Log log) {
			System.out.println(log.dateTime);
		}
		
	}
@Test
void dateTime() throws Exception {
	Log log = new Log(new Date(), LogType.NO_EXCEPTION, "logger", 0, "");
	log.artifact = null;
	String logJson = mapper.writeValueAsString(log);
	System.out.println(logJson);
	assertEquals(400, mock.perform(post("/").contentType(MediaType.APPLICATION_JSON)
			.content(logJson)).andReturn().getResponse().getStatus());
	;
	
}
}

