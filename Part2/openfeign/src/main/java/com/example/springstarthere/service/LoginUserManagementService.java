package com.example.springstarthere.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @SessionScope : 해당 Bean의 생명주기를 Session 범위로 설정
 */
@Service
@SessionScope
public class LoginUserManagementService {

	private String id;

	@PostConstruct
	public void init() {
		System.out.println("-----------Init LoginUserManagementService-----------");
	}

	@PreDestroy
	public void close() {
		System.out.println("-----------Close LoginUserManagementService-----------");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println("Current LogIn ID : " + id);
	}

}
