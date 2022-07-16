package com.example.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Product;
import com.example.app.service.IProductService;


@RestController
@RequestMapping("/rest/prod")
public class ProductRestController {
	
	@Autowired
	private IProductService service;
	public static final String PRODUCT_SERVICE="productService";


	//1. save product
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(
			@RequestBody Product product
			)
	{
		ResponseEntity<String> resp =null;
		try {
			Integer id = service.saveProduct(product);
			resp = new ResponseEntity<String>(
					"Product Created!"+id,
					HttpStatus.CREATED); 
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to save Product!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//2. find all product
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts() {
		ResponseEntity<?> resp = null;
		try {
			List<Product> list = service.getAllProduct();
			resp = new ResponseEntity<List<Product>>(
					list,HttpStatus.OK);//200-Ok

		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to fetch Products!",
					HttpStatus.INTERNAL_SERVER_ERROR);//500-Exception
		}

		return resp;
	}
	
	//3. fetch one product by id
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneProduct(
			@PathVariable Integer id
			) 
	{
		ResponseEntity<?> resp = null;

		try {
			Product p = service.getOneProduct(id);
			//resp = new ResponseEntity<Product>(p,HttpStatus.OK);//200
			resp = ResponseEntity.ok(p);


		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to fetch Product By id!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}


	//4. delete product
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteProduct(
			@PathVariable Integer id
			) 
	{
		ResponseEntity<String>  resp = null;

		try {
			service.deleteProduct(id);
			resp = ResponseEntity.ok("Product '"+id+"' Deleted!");
		
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to delete Product By id!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}


	//5. update product
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(
			@RequestBody Product product
			) 
	{
		ResponseEntity<String> resp = null;
		try {
			service.updateProduct(product);
			resp = ResponseEntity.ok("Product Updated!");
		
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to Update Product!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

}
