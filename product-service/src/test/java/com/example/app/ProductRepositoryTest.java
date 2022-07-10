package com.example.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.app.model.Product;
import com.example.app.repo.ProductRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository repo;
	
	@BeforeEach
	public void init()
	{
		List<Product>  list= new ArrayList<>();
		
		list.add(new Product(1, "Type", 500.0, "Vendor"));
		
		repo.saveAll(list);
	}
	@AfterEach
    public void destroyAll(){
        repo.deleteAll();
    }
	
	@Test
    void findAllTest() {
        List<Product> allCustomer = repo.findAll();
        assertThat(allCustomer.size()).isGreaterThanOrEqualTo(1);
    }
	@Test
	void getByIdTest() {
		Product id = repo.getReferenceById(1);
		assertNotNull(id);
	}
	@Test
	void saveTest() {
		Product id = repo.save(new Product(2, "HardDisk", 500.0, "Seagate"));
		assertEquals("HardDisk", id.getProdCode());
	}
}
