package com.example.springstarthere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springstarthere.model.Product;
import com.example.springstarthere.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @PostMapping : HTTP GET 메서드에 매핑되도록 지정하는 어노테이션
	 */
	@GetMapping("/products")
	public String viewProducts(Model model) {

		var products = productService.findAll();
		model.addAttribute("products", products);

		return "products";

	}

	/**
	 * @PostMapping : HTTP POST 메서드에 매핑되도록 지정하는 어노테이션
	 */
	@PostMapping( "/product")
	public String addProduct(
		@RequestParam String name,
		@RequestParam Double price,
		Model model
	) {

		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		productService.addProduct(p);

		var products = productService.findAll();
		model.addAttribute("products", products);

		return "products";

	}

}