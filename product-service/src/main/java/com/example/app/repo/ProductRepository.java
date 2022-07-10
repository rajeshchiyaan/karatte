package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.model.Product;

public interface ProductRepository 
	extends JpaRepository<Product, Integer> {

}
