package com.example.storeApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeApplication.model.Product_Service;
import com.example.storeApplication.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product_Service> getAllProducts(){
		return productRepository.findAll();
	}

}
