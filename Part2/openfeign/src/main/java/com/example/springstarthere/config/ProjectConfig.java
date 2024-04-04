package com.example.springstarthere.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableFeignClients : OpenFeign 기능을 활성화하고 OpenFeign에게 Client에게 검색할 위치를 알려주기 위한 어노테이션
 */
@EnableFeignClients(basePackages = "com.example.springstarthere.proxy")
@Configuration
public class ProjectConfig {
}
