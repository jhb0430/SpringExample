package com.jhb0430.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드에 @ResponseBody가 적용된다
@RestController	// @Controller + @Responsebody
@RequestMapping("/lifecycle/ex01") // 공통된 요소를 가장 상위 클래스에 묶어서 적어준다 
public class Ex01RestController {

	// 직접 만든 클래스 객체 리턴
	
	//@ResponseBody
//	@RequestMapping("/lifecycle/ex01/3")
	@RequestMapping("/3")
	public Person objectResponse() {
		
		Person me = new Person("김인규", 31);
		
		return me;
	}
	
	
	// status code (=http status code) 적용
		// →요청에 대한 처리의 상태를 정해진 코드로 표현하는 것 
		//  2XX 성공  3xx , 4xx 클라이언트 에러  5xx 서버 에러
	
//	@RequestMapping("/lifecycle/ex01/4")
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		
		Person me = new Person("김인규", 31);
		
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity; 
		
	}
	
	
	
}
