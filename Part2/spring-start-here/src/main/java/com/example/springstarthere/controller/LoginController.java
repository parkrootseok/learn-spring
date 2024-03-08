package com.example.springstarthere.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springstarthere.SpringStartHereApplication;
import com.example.springstarthere.proccessor.LoginProcessor;

@Controller
public class LoginController {

	private final LoginProcessor loginProcessor;

	public LoginController(LoginProcessor loginProcessor) {
		this.loginProcessor = loginProcessor;
	}

	@GetMapping("/")
	public String loginGet() {
		return "login";
	}

	@PostMapping("/")
	public String loginPost(
		@RequestParam String id,
		@RequestParam String password,
		Model model
	) {

		loginProcessor.setId(id);
		loginProcessor.setPassword(password);

		boolean isLoginable = loginProcessor.login();

		if (isLoginable) {
			model.addAttribute("message", "Login Success!");
		}

		else {
			model.addAttribute("message", "Login Fail!");
		}

		return "login";

	}

}
