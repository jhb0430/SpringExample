package com.jhb0430.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.ex.jpa.domain.Student;
import com.jhb0430.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// create, update, delete
	
	// 한 학생의 정보 저장 기능
	
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent(){
		// create 요청이 들어오면 
		// 김어쩌구,010-1234-5678,bla@lala.com, 개발자
		Student student = studentService.addStudent("김어쩌구", "010-1234-3245", "bla@lala.com", "개발자");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 사람의 장래희망을 강사로 변경
		
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	
	@GetMapping("/delete")
	public String deleteStudent() {
		
		// id가 3인 사람 삭제
		studentService.deleteStudent(3);
		
		return "삭제";
		
	}
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		
//		Student student = new Student(); // 생성자가 하나라도 만들어지면 기본 생성자를 쓸 수 없게된다 .(원래는)
		//@AllArgsConstructor 추가로 이제 이렇게 사용 가능
//		Student student = new Student(1,"김인규","010-1234-5678","lecture@hagulu.com","개발자",null,null);
//		student.setName("김인규");
//		student.setEmail("lecture@hagulu.com");
//		student.setPhoneNumber("010-1234-5678");
		
		// builder 패턴
		Student student = 	Student.builder().name("김인규")
											.email("lecture@hagulu.com")
											.phoneNumber("010-1234-5678").build();
		
		return student;
		
		
		
	}
}
