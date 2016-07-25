package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newtonapples.domain.Response;
import com.newtonapples.domain.Student;

@RestController
public class ResponseEndpoint {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/getStudentInfo")
	public Response getStudents(@RequestBody String body) {
		
		System.out.println("*********");
		System.out.println(body);
		System.out.println("*********");
		
		ObjectMapper mapper = new ObjectMapper();
		Response request = null;
		try{
			request = mapper.readValue(body, Response.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		Response response = new Response();
		Student student = new Student();
			student.setActive(true);
			student.setBatchNo("NW Adv-2");
			student.setCourse("Adv Java");
			student.setName("Mounika");
			
		response.getStudentsList().add(student);
		return response;
	}
	
}