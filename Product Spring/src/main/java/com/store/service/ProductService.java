package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.model.Product;
import com.store.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}
	public List<Product> getProducts(){
		return (List<Product>) productRepository.findAll();
		
	}
	
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
	public Product updateProduct(Product product) {
		Integer id=product.getId();
		Product pro=productRepository.findById(id).get();
		pro.setName(product.getName());
		pro.setGender(product.getGender());
		pro.setBrand(product.getBrand());
		pro.setCategory(product.getCategory());
		pro.setQuantity(product.getQuantity());
		pro.setPrice(product.getPrice());
		return productRepository.save(pro);
		
		
	
	}
}
