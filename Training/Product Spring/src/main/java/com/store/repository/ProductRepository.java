package com.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Product;



@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
	

}
