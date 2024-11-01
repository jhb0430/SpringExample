package com.jhb0430.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/ex02")
	public String thymleafEx() {
		return "lifecycle/ex02";
		//		url과 헷갈릴 수 있으니까  앞에 / 안적어준다. html의 경로
	}
}
