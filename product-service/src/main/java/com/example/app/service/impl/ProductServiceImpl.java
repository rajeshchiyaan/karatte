package com.example.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Product;
import com.example.app.repo.ProductRepository;
import com.example.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo; 

	@Override
	public Integer saveProduct(Product p) {
		Product product = repo.save(p);
		return product.getProdId();
	}

	@Override
	public Integer updateProduct(Product p) {
		Integer prodId =  0;
		if(repo.existsById(p.getProdId())) {
			prodId = repo.save(p).getProdId();
		}
		return prodId;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = repo.findAll();
		return list;
	}

	@Override
	public Product getOneProduct(Integer id) {
		
		Optional<Product> opt =  repo.findById(id);
			return opt.get();
		
	}

	@Override
	public Integer deleteProduct(Integer id) {
		repo.delete(getOneProduct(id));
		return id;
	}
	
}
