package com.example.springstarthere.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {

	private int count;

	@PostConstruct
	public void init() {
		System.out.println("-----------Init LoginCountService Bean!!-----------");
	}

	@PreDestroy
	public void close() {
		System.out.println("-----------Close LoginCountService Bean!!-----------");
	}

	public void increment() {
		count++;
	}

	public int getCount() {
		return this.count;
	}

}
