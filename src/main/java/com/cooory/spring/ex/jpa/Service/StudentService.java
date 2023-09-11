package com.cooory.spring.ex.jpa.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooory.spring.ex.jpa.Repository.StudentRepository;
import com.cooory.spring.ex.jpa.domain.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
	
		
		Student student = Student.builder()
							.name(name)
							.phoneNumber(phoneNumber)
							.email(email)
							.dreamJob(dreamJob)
							.build();
							
		
		student = studentRepository.save(student);
		
		return student;
	}
	
	// 특정 id의 학생정보에서 장래희망을 수정하는 기능
	public Student updateStudent(int id, String dreamJob) {
		
		// update 대상의 행을 조회한다.
		// 조회 된 데이터 객체에서 수정 할 내용을 멤버 변수 값을 변경
		// 해당 객체를 저장한다.
		
		// Optional
		// null 일수도 있는 객체를 리턴할 때 쓰는 클래스
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		if (student != null) {
			student = student.toBuilder()
			.dreamJob(dreamJob)
			.build();
			
			student = studentRepository.save(student);
		}
		
		return student;
	}
	
	public void deleteStudent(int id) {
		// 삭제 대상 행을 조회해온다.
		// 객체 기반으로 삭제 한다.
		
//		Student student = studentRepository.findById(id).orElse(null);
//		
//		if (student != null) {
//			studentRepository.delete(student);
		
//		}
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// 람다식
		optionalStudent.ifPresent(student -> studentRepository.delete(student)); // 만약 null이 아니라면
	}
}
