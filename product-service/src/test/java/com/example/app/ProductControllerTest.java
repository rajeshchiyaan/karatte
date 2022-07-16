package com.example.app;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.app.model.Product;
import com.example.app.rest.ProductRestController;
import com.example.app.service.IProductService;

@RunWith(JUnitPlatform.class)
public class ProductControllerTest {

	@InjectMocks
	private ProductRestController productRestController;
	@Mock
	private IProductService productService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(productService.saveProduct(new Product(1, "Type", 500.0, "Vendor"))).thenReturn(1);
		Mockito.when(productService.getAllProduct()).thenReturn(Arrays.asList(new Product(1, "Type", 500.0, "Vendor")));
		Mockito.when(productService.updateProduct(new Product(1, "Type", 500.0, "Vendor Typeeeee"))).thenReturn(1);
		Mockito.when(productService.deleteProduct(1)).thenReturn(1);
	}

	@Test
	public void saveProductTest() {

		ResponseEntity<String> responseEntity = productRestController
				.saveProduct(new Product(1, "Type", 500.0, "Vendor"));
		Assert.assertEquals("status should be " + HttpStatus.CREATED, HttpStatus.CREATED,
				responseEntity.getStatusCode());

	}

	@Test
	public void getAllProductsTest() {
		@SuppressWarnings("unchecked")
		ResponseEntity<List<Product>> responseEntity = (ResponseEntity<List<Product>>) productRestController
				.getAllProducts();
		Assert.assertEquals("status should be " + HttpStatus.OK, HttpStatus.OK, responseEntity.getStatusCode());

		List<Product> body = responseEntity.getBody();
		Assert.assertNotNull(body);

	}
	@Test
	public void updateTest() {

		ResponseEntity<String> responseEntity = productRestController
				.updateProduct(new Product(1, "Type", 500.0, "Vendor Typeee"));
		Assert.assertEquals("status should be " + HttpStatus.OK, HttpStatus.OK,
				responseEntity.getStatusCode());

	}
	@Test
	public void deleteTest() {

		ResponseEntity<String> responseEntity = productRestController
				.deleteProduct(1);
		Assert.assertEquals("status should be " + HttpStatus.OK, HttpStatus.OK,
				responseEntity.getStatusCode());

	}

}
