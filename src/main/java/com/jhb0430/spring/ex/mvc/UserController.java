package com.jhb0430.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhb0430.spring.ex.mvc.domain.User;
import com.jhb0430.spring.ex.mvc.service.UserService;

import ch.qos.logback.core.model.Model;

@RequestMapping("/mvc/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// 사용자 정보를 request 파라미터로 전달 받고, 저장하는 기능
/*	
http의 메소드(get/post)에 대한 정보가 어디에도 없는데, -> @RequestMapping 안에 숨겨져있던 기능!
	→	@RequestMapping("/mvc/user/create") 안에는 @RequestMapping(path= "/mvc/user/create", method=RequestMethod.GET)이 숨겨져있음!!
	→	POST 형식으로 바꾸고 싶으면  @RequestMapping(path= "/mvc/user/create", method=RequestMethod.POST)로 바꿔주면 된다
		근데 너무 길다?  @PostMapping 이라는 어노테이션을 활용하면 된다 !    = > @PostMapping(/mvc/user/create)
*/	
	
//	@RequestMapping("/mvc/user/create")
	@PostMapping("/create")
	// 포스트 맵핑은 요청방식이 폼인데... html 구성해서 써야하는데 -> servlet 기억나죵..???
	@ResponseBody
	public String createUser(
			@RequestParam("name")String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce")String introduce){
	// 요청에 의해 전달된 파라미터를 전달할 것이기 때문에 @RequestParam
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		return "삽입 성공 : " + count;
	}
	
	// 얘는 ResponseBody가 안붙는다 
	@GetMapping("/input")// 겟메소드 기반으로 맵핑한다
	public String userInput() {
		return "mvc/userInput";
		// templates 아랫경로만 적어주면 된다 (urlMapping과 달리)
	}
	
	
	
	
	// 1. 샘플데이터를 가지고 html을 통해 화면 구성
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		// 가장 최근에 등록한 한 사용자 정보 얻어오기
		// -> 서비스에 만들러 고고고 
		User user = userService.getLastUser();
		
		// html - model - controller  잘 기억하기  ↑ model 어케씀?? 위에 봐봐 
		// 컨트롤러가 모델에게 할 일은 딱 하나, 모델을 추가하는 것 뿐임
		// 리턴한 경로의 html에서 사용할 데이터를 model 에 추가한다.
//		model.addAttribute("key",value);
		model.addAttribute("title","마지막 사용자 정보");
		model.addAttribute("result",user);
//							user객체를 다룰 정보 
		
		return "mvc/userInfo";
	}
}
