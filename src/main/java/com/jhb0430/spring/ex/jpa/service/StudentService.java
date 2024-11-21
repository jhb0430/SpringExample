package com.jhb0430.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhb0430.spring.ex.jpa.domain.Student;
import com.jhb0430.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamjob){
	
		Student student = Student.builder()
								 .name(name)
								 .phoneNumber(phoneNumber)
								 .email(email)
								 .dreamJob(dreamjob)
								 .build();
//		Student.builder().name("김뫄뫄")
//						 .phoneNumber("010-7777-8888")
//						 .email("mmss@blabla.com)
		
		Student result = studentRepository.save(student);
		
		return result;
		
		
	}
	
	public Student updateStudent(int id, String dreamJob){
		// update 대상을 조회한다
		// 조회된 결과 객체를 얻어온다
		// 조회된 객체에서 수정사항을 적용한다
		// 수정된 객체를 저장한다.
		
		// Optional 객체
		// null 일 수 도 있는 객체를 null 을 처리하는 기능으로 감싸놓은 객체
		// null을 다룰 때 발생될 수 잇는 NullPointerExcepion을 위험없이 처리하도록 도와준다.
		// null 일수도 있는 객체를 리턴하는 메소드에서 리턴타입으로 주로 사용
		Optional<Student > optionalStudent = studentRepository.findById(id);
//												null이면 null 리턴. 아니면 객체 리턴
		Student student = optionalStudent.orElse(null);
		//								orElse(new Student()) 	 -> new student 리턴	
		student = student.toBuilder().dreamJob(dreamJob).build();
//		student.setDreamJob(dreamjob);
		
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	
	public void deleteStudent(int id) {
		
		// 삭제 대상을 조회한다 .
		// 조회된 객체를 통해 삭제한다.
		
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
		
	}
	
	
}
