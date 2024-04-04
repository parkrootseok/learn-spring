package com.example.springstarthere.proccessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.springstarthere.service.LoginCountService;
import com.example.springstarthere.service.LoginUserManagementService;

/**
 * @RequestScope : Bean의 범위를 RequestScope로 설정하기 위한 어노테이션
 * -> HTTP 요청에 대해서만 새로운 인스턴스를 생성
 */
@Component
@RequestScope
public class LoginProcessor {

	private final LoginUserManagementService loginUserManagementService;
	private final LoginCountService loginCountService;

	private String id;
	private String password;

	public LoginProcessor(LoginUserManagementService loginUserManagementService, LoginCountService loginCountService) {
		this.loginUserManagementService = loginUserManagementService;
		this.loginCountService = loginCountService;
	}

	@PostConstruct
	public void init() {
		System.out.println("-----------Init LoginProcessor-----------");
	}

	@PreDestroy
	public void close() {
		System.out.println("-----------Close LoginProcessor-----------");
	}

	public boolean login() {

		loginCountService.increment();

		String id = this.getId();
		String password = this.getPassword();

		if ("root".equals(id) && "password".equals(password)) {
			// 로그인이 수행된 경우 세션 범위를 가지는 Bean에 로그인 정보를 저장
			loginUserManagementService.setId(id);
			return true;
		}

		return false;

	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
