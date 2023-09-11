package com.cooory.spring.ex.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cooory.spring.ex.jpa.domain.Student;

@Controller
public class StudentController {

	@GetMapping("/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student();
//		student.setName("이정현");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-6705-1459");
		
		Student student = Student.builder()
							.name("이정현")
							.dreamJob("개발자")
							.phoneNumber("010-6705-1459")
							.build();
		
		return student;
	}
}
