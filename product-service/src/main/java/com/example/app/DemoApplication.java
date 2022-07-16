package com.example.app;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.model.Product;
import com.example.app.repo.ProductRepository;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner{

	@Autowired
	private ProductRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
        repo.saveAll(Arrays.asList(new Product(1, "Type", 500.0, "Vendor"),new Product(2,"Mobile",5000.0,"Samsung")));
	}

}
