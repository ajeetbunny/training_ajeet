package com.example.storeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeApplication.model.Product_Service;

public interface ProductRepository extends JpaRepository<Product_Service,Integer> {

	
}
