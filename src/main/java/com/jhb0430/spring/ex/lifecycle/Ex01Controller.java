package com.jhb0430.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*	
Jackson Library
java기반 Json 유틸 라이브러리
spring-boot-starter-web에 포함
객체, 자료구조를 자동으로 Json으로 변경시켜준다
객체의 경우 변수명이 key 값이 value인 맵 형태가 된다
*/	
	@Controller
	public class Ex01Controller {
	
		// 간단한 html 코드를 response 로 만드는 페이지
		@ResponseBody
		@RequestMapping("/lifecycle/ex01/1")
		public String stringResponse() {
			return "<h1>예제 1번 문자열 담기 </h1>";
			
			
		
		}
		
	// 맵 데이터를 response에 담는 페이지 
		@ResponseBody
		@RequestMapping("/lifecycle/ex01/2")
		public Map<String, Integer> mapResponse(){
			
		// 과일 이름 : 가격 
		Map<String, Integer> fruitMap = new HashMap<>();
	
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 4500);
		fruitMap.put("orange", 1300);
	return fruitMap;
		}
	
}
