package com.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Product;
import com.store.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders= "*", origins="*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
		
	}
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		List<Product>productAdded=new ArrayList<Product>();
		productAdded=productService.getProducts();
		return productAdded;
		
	}
	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@RequestParam Integer id)
	{
		productService.deleteProduct(id);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
		
	}

}
