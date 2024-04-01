package com.example.springstarthere.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstarthere.model.Country;

@RestController
public class CountryController {


	@GetMapping("/all")
	public List<Country> countries() {

		Country c1 = Country.of("France", 67);
		Country c2 = Country.of("Spain", 47);

		return List.of(c1, c2);

	}


	@GetMapping("/france")
	public Country france() {

		Country c = Country.of("France", 67);
		return c;

	}


}
