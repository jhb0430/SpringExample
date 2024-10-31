package com.jhb0430.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody	// object 타입인듯
	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World!!";
		
	}
	

}
