package com.jhb0430.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhb0430.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {

	private UserService userService;
	// 있는건 갖다 써라 
	
	
	// 사용자 추가 API
	
	// 이름 생일 이메일 자기소개
	
	@PostMapping("/ajax/user/create")
	public Map<String, String> crateUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			) {
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		// api -> 어떤 결과를 데이터로 담아야한다는 건데... 어떻게?? 
		// 이런 단순한 기능수행 결과라면 성공 실패 여부를 나눠서 데이터화해주면 좋지 않을까 ?
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 {"result":"success"}
		// 실패  {"result" : "fail"}
		
		if(count == 1) {
			// 성공
			resultMap.put("result","success");
		}
		else {
			resultMap.put("result","fail");
			
		}
		
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String userInput() {
		
		return "ajax/userInput";
	}
	
	
	
	
	
}
