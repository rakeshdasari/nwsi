package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// @RequestMapping("/greeting")
	// public Greeting greeting(@RequestParam(value="name",
	// defaultValue="World") String name) {
	// return new Greeting(counter.incrementAndGet(),
	// String.format(template, name));
	// }
	@RequestMapping("/greeting")
	public ResponseWrapper greeting(@RequestParam(value = "name") String name) {

		List<Student> StudentList = new ArrayList<Student>();

		ResponseWrapper wrapper = new ResponseWrapper();
		Student st1 = new Student();

		st1.setName("Samrat");
		st1.setCourse("Advanced Java");
		st1.setActive("Yes");
		st1.setBatchno(2);

		StudentList.add(st1);

		Student st2 = new Student();

		st2.setName("Mounika");
		st2.setCourse("Advanced Java");
		st2.setActive("Yes");
		st2.setBatchno(2);

		StudentList.add(st2);

		
		for (Student student : StudentList) {
			if (name.equals(student.getName())) {
				wrapper.setStudent(student);
			}
		}

		return wrapper;
	}
	
}