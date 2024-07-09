package com.example.springstarthere.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry resourceHandlerRegistry) {

		resourceHandlerRegistry
			.addResourceHandler("/**")
			.addResourceLocations("classpath:templates/", "classpath:static/")
			.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));

	}


}
