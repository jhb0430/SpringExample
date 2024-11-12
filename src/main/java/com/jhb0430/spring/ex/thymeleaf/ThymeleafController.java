package com.jhb0430.spring.ex.thymeleaf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {

	@GetMapping("/ex01")
	public String ex01() {
		return "thymeleaf/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// 해당하는 메소드에서 모델의 값을 채워주면 html이 쓸 수 있다 
		
		// 과일 이름 리스트
		List<String> fruitList = new ArrayList<>();
		
		fruitList.add("사과");
		fruitList.add("귤");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		
		// 사용자 정보 관리 리스트
		// "name":"김인규", "age":29,"hobby":"독서"
		List<Map<String,Object>> userList = new ArrayList();
		
		Map<String,Object> userMap = new HashMap<>();
		userMap.put("name","김인규");
		userMap.put("age",29);
		userMap.put("hobby","독서");
		userList.add(userMap);
		
		userMap = new HashMap<>();
		userMap.put("name","바다");
		userMap.put("age",5);
		userMap.put("hobby","사냥하기");
		userList.add(userMap);
		
		
		model.addAttribute("userList", userList);
		
		return "thymeleaf/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date date = new Date();
		LocalDate localDate = LocalDate.now(); // 현재 날짜를 관리
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("date",date);
		model.addAttribute("localDate",localDate);
		model.addAttribute("localDateTime",localDateTime);
		
		return "thymeleaf/ex03";
	}
	
}
