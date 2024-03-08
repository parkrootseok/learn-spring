package com.example.springstarthere.proccessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @RequestScope : Bean의 범위를 RequestScope로 설정하기 위한 어노테이션
 * -> HTTP 요청에 대해서만 새로운 인스턴스를 생성
 */
@Component
@RequestScope
public class LoginProcessor {

	private String id;
	private String password;

	@PostConstruct
	public void init() {
		System.out.println(this);
	}

	@PreDestroy
	public void close() {
		System.out.println(this);
	}

	public boolean login() {

		String id = this.getId();
		String password = this.getPassword();

		if ("root".equals(id) && "password".equals(password)) {
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
