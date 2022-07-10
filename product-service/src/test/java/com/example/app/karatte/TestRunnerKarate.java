package com.example.app.karatte;

import com.intuit.karate.junit5.Karate;

public class TestRunnerKarate {

	@Karate.Test
	Karate testGetAllProducts() {
		return Karate.run("GetAllProducts").relativeTo(getClass());
	}
	@Karate.Test
	Karate testSaveProduct() {
		return Karate.run("SaveProduct").relativeTo(getClass());
	}
	@Karate.Test
	Karate testUpdateProduct() {
		return Karate.run("UpdateProduct").relativeTo(getClass());
	}
	@Karate.Test
	Karate testGetProduct() {
		return Karate.run("GetProduct").relativeTo(getClass());
	}
	@Karate.Test
	Karate testDeleteProduct() {
		return Karate.run("DeleteProduct").relativeTo(getClass());
	}
	
	@Karate.Test
	Karate testAll() {
		return Karate.run("All").relativeTo(getClass());
	}
}
