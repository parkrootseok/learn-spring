package com.example.springstarthere.controller;

import java.util.Objects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springstarthere.SpringStartHereApplication;
import com.example.springstarthere.proccessor.LoginProcessor;
import com.example.springstarthere.service.LoginUserManagementService;

@Controller
public class LoginController {

	private final LoginUserManagementService loginUserManagementService;
	private final LoginProcessor loginProcessor;

	public LoginController(LoginUserManagementService loginUserManagementService, LoginProcessor loginProcessor) {
		this.loginUserManagementService = loginUserManagementService;
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

		/**
		 * 1, 로그인 수행
		 */
		System.out.println("----------로그인 수행--------------");
		boolean isLoginable = loginProcessor.login();
		System.out.println("----------로그인 완료--------------");

		/**
		 * 2. 로그인이 완료되었다면 main으로 리다이렉션
		 */
		if (isLoginable) {
			return "redirect:/main";
		}

		/**
		 * 3. 로그인이 완료되지 못했다면 실패 표시 후 로그인 페이지로 이동
		 */
		System.out.println("----------로그인 실패--------------");
		model.addAttribute("message", "Login Fail!");
		return "login";

	}

	@GetMapping("/main")
	public String home(
		@RequestParam(required = false) String logout,
		Model model
	) {

		/**
		 * 1.로그아웃을 진행했을 경우 세션에 저장된 id를 초기화
		 */
		if (logout != null) {
			System.out.println("----------로그아웃 수행--------------");
			System.out.println("로그아웃 수행 전 ID: " + loginUserManagementService.getId());
			loginUserManagementService.setId(null);

			System.out.println("----------로그아웃 완료--------------");
			System.out.println("로그아웃 수행 후 ID: " + loginUserManagementService.getId());
		}

		/**
		 * 2. 로그아웃에 대한 정보가 없다면 세션에 저장된 id를 가져온다.
		 */
		System.out.println("현재 로그인 중인 정보 조회");
		String curLoginID = loginUserManagementService.getId();
		System.out.println("현재 로그인 중인 ID: " + curLoginID);

		/**
		 * 3. 현재 로그안한 아이디에 대한 정보가 없을 경우 로그인 페이지로 유도하고
		 * -> LoginUserManagementService는 Session-Scoped Bean으로 이전에 로그인을 진행했다면 이에 대한 정보가 남아 있음
		 */
		if (curLoginID == null) {
			System.out.println("로그인 정보가 없으므로 로그인 페이지로 유도");
			return "redirect:/";

		}

		/**
		 * 4. 정보가 있다면 홈페이지로 유도한다.
		 */
		System.out.println("로그인 정보가 있으면 main으로 유도");
		model.addAttribute("id", curLoginID);
		return "main";

	}

}
