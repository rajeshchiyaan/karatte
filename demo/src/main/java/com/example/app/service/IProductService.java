package com.example.app.service;

import java.util.List;

import com.example.app.model.Product;

public interface IProductService {

	Integer saveProduct(Product p);

	Integer updateProduct(Product p);

	List<Product> getAllProduct();

	Product getOneProduct(Integer id);

	Integer deleteProduct(Integer id);
}
