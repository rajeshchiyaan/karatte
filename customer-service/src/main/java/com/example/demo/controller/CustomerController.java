package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	public static final String PRODUCT_SERVICE="productService";
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private int attempts=1;
	
	@GetMapping("/products")
//	@CircuitBreaker(name =PRODUCT_SERVICE,fallbackMethod = "getAllAvailableProducts")
	@Retry(name = PRODUCT_SERVICE,fallbackMethod = "getAllAvailableProducts")
	public ResponseEntity<?> getProducts()
	{
		logger.info("item service call attempted:::"+ attempts++);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> forEntity = restTemplate.getForEntity("http://localhost:9092/rest/prod/all",Object[].class );
		return forEntity;
	}
	public ResponseEntity<?> getAllAvailableProducts(Exception e){
		attempts = 1;
//        return new ResponseEntity<List<Product>>(Stream.of(
//                new Product(101,"Mobile",10000.0,"Samsung")
//                
//        ).collect(Collectors.toList()),HttpStatus.OK);
		return new ResponseEntity<String>("Product Service Down ..",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
