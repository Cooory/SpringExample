package com.cooory.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cooory.spring.ex.jpa.Repository.StudentRepository;
import com.cooory.spring.ex.jpa.Service.StudentService;
import com.cooory.spring.ex.jpa.domain.Student;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository; // 원래 컨트롤러에서 레파시토리 접근 X
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		
		String name = "이정현";
		String phoneNumber = "010-6705-1459";
		String email = "cory1459@gmail.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		
		return student;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		
		// id가 3인 학생정보의 장래희망을 강사로 수정
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String deleteStudent() {
		
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		
		return "Delete Completed";
	}
	
	@GetMapping("/select")
	@ResponseBody
	public List<Student> selectStudent() {
		
		// 모든 행 조회
//		List<Student> studentList = studentRepository.findAll();
		
		// id 기준으로 내림차순으로 정렬한 모든 행 조회
//		List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
		// id를 기준으로 내림차순으로 정렬 후 하나만 조회
//		List<Student> studentList = studentRepository.findTop1ByOrderByIdDesc();
		
		// name 컬럼이 일치하는 데이터 조회
//		List<Student> studentList = studentRepository.findByname("유재석");
//		
		// name 컬럼이 일치하는 데이터 조회
		// name` IN ("유재석", "조세호")
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
		
		// email 컬럼에 특정 문자열이 포함 된 데이터 조회
		// `email` Like "%naver%"
//		List<Student> studentList = studentRepository.findByNameIn(nameList);
		
		
		// email 컬럼에 특정 문자열이 포함 된 데이터 조회
		// `email` Like "%naver%"
//		List<Student> studentList = studentRepository.findByEmailContaining("naver");
		
		
		// id가 특정 값들 사이에 대응되는 데이터를 조회 id 기준으로 내림차순
		// `id` BETWEEN 1 AND 2
//		List<Student> studentList = studentRepository.findByIdBetweenOrderByIdDesc(1, 2);
		
		// 쿼리를 통한 조회
		// dreamJob 컬럼이 일치하는 데이터 조회
		List<Student> studentList = studentRepository.findByDreamJobQuery("모델");
		return studentList;
	}

	
	
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
