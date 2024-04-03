package com.example.springstarthere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringStartHereApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartHereApplication.class, args);
	}

}
