package com.example.springstarthere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/hello")
	/**
	 * @ResponseBody : DispatcherServlet에게 데이터를 View가 아닌 HTTP Response로 직접 전송함을 알리기 위한 어노테이션
	 */
	@ResponseBody
	public String hello() {
		return "hello";
	}

}
