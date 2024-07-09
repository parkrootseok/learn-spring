package com.example.springstarthere.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController : 모든 메서드마다 @ResponseBody 주석을 반복하는 것을 피하기 위한 어노테이션
 * -> 자동으로 모든 메서드에 @ResponseBody 어노테이션을 추가
 * -> ResponseBody + Controller = RestController
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
