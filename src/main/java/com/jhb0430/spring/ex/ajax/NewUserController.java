package com.jhb0430.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {

	@Autowired
	private UserService userService;
	// 있는건 갖다 써라 
	
	
	// 사용자 추가 API
	
	// 이름 생일 이메일 자기소개
	
	@ResponseBody // 얘가 없으면 리턴된 값이 html 경로로 인식해서 html을 찾으려고 시도한다... 
	@PostMapping("/create")
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
	
	//View
	@GetMapping("/input")
	public String userInput() {
		
		return "ajax/userInput";
	}
	
	// email 전달 받고 , 이미 추가된 email 인지 확인
	// API
	// -> 요청을 처리하고 수행하는 기능까지는 똑같디
	// 중복여부를 파악해주는 기능
	@ResponseBody
	@GetMapping("/duplicate-email")
	public Map<String,Boolean> isDuplicateEmail(@RequestParam("email")String email) {
		
		boolean isDuplicate = userService.isDuplicateEmail(email);
		
		// Response 정리 .. 이제 결과를 전달해줘야하는데 (API)
		// 중복 됨 {"isDuplicate" : true}
		// 중복 안됨 {"isDuplicate" : false} 
		//라고 셋팅을해서 리스폰스에 담아두면 쓰는 사람이 보고 알아서 거를것이다
//						key, value 형태네? -> 맵

			Map<String,Boolean> resultMap = new HashMap<>();
				// isDuplicate가 트루면 맵에 {"isDuplicate" : true} 저장
			if(isDuplicate) { // isDuplicate == true boolean 자체가 true false 인지 아닌지의 타입이라 안적어줘도 됨
				resultMap.put("isDuplicate", true);
			} else {
				resultMap.put("isDuplicate", false);
			}
			
			return resultMap;
		
	}
	
	
	
}
