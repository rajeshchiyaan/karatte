package com.example.app;

import static org.mockito.ArgumentMatchers.any;

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

import com.example.app.model.Product;
import com.example.app.repo.ProductRepository;
import com.example.app.service.impl.ProductServiceImpl;

@RunWith(JUnitPlatform.class)
public class ProductServiceTest {
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	@Mock
	private ProductRepository productRepositoryRepo;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void saveProductTest() {
		Product product = new Product(1, "Type", 500.0, "Vendor");
		Mockito.when(productRepositoryRepo.save(any(Product.class)))
				.thenReturn(product);
		Integer response = productServiceImpl.saveProduct(new Product(1, "Type", 500.0, "Vendor"));
		Assert.assertEquals((Integer) 1, response);

	}

	@Test
	public void getAllProductsTest() {
		Product product = new Product(1, "Type", 500.0, "Vendor");
		Mockito.when(productRepositoryRepo.findAll()).thenReturn(Arrays.asList(product));
		Mockito.when(productRepositoryRepo.existsById(product.getProdId())).thenReturn(true);
		List<Product> allProduct = productServiceImpl.getAllProduct();
		Assert.assertNotNull(allProduct);

	}

	@Test
	public void updateTest() {
		Product product = new Product(1, "Type", 500.0, "Vendor");
		Mockito.when(productRepositoryRepo.existsById(product.getProdId())).thenReturn(true);
		Mockito.when(productRepositoryRepo.save(any(Product.class)))
				.thenReturn(new Product(1, "Type", 500.0, "Vendor Typeeee"));
		Integer response = productServiceImpl.updateProduct(new Product(1, "Type", 500.0, "Vendor Typeeee"));
		Assert.assertEquals((Integer) 1, response);

	}

}
