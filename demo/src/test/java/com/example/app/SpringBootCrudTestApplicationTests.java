package com.example.app;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("PRODUCT REST CONTROLLER")
class SpringBootCrudTestApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	@DisplayName("SAVE PRODUCT")
	public void testSaveProduct() throws Exception {
		//1. create one mock request with all details
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders
				.post("/rest/prod/save")  //Method Type + Path
				.contentType("application/json") // Header Param
				.content("{\"prodId\": 1,\"prodCode\": \"ABC\", \"prodCost\": 500.0, \"prodVendor\": \"IJK\"}");  //Body


		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read response from result
		MockHttpServletResponse response = result.getResponse();

		//4. assert response
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}

	@Test
	@Order(2)
	@DisplayName("FETCHIG ALL PRODUCTS")
	public void testGetAllProducts() throws Exception {
		//1. create one mock request with all details
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.get("/rest/prod/all");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read response from result
		MockHttpServletResponse response = result.getResponse();

		//4. assert response
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		

	}

	@Test
	@Order(3)
	@DisplayName("FETCHIG ONE PRODUCT BY ID")
	public void testGetOneProduct() throws Exception {
		//1. create one mock request with all details
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.get("/rest/prod/find/1");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read response from result
		MockHttpServletResponse response = result.getResponse();

		//4. assert response
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
		if(response.getContentAsString().isEmpty()) {
			fail("No Data Provided!");
		}
		
	}
	
	@Test
	@Order(4)
	@DisplayName("UPDATE PRODUCT")
	public void testUpdateProduct() throws Exception {
		//1. create one mock request with all details
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders
				.put("/rest/prod/update")  
				.contentType("application/json") 
				.content("{\"prodId\":1,\"prodCode\": \"TTRRYY\", \"prodCost\": 500.0, \"prodVendor\": \" TEST Vendor\"}");  //Body


		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read response from result
		MockHttpServletResponse response = result.getResponse();

		//4. assert response
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if(!response.getContentAsString().contains("Product Updated!")) {
			fail("Product Not saved!");
		}
	}
 

	@Test
	@Order(5)
	@DisplayName("DELETE ONE PRODUCT BY ID")
	public void testDeleteProduct() throws Exception {
		//1. create one mock request with all details
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.delete("/rest/prod/remove/1");

		//2. execute request and get result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. Read response from result
		MockHttpServletResponse response = result.getResponse();

		//4. assert response
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		if(!response.getContentAsString().contains("Deleted!")) {
			fail("Product Id may be not exist, or code is not working");
		}
	}
	
	
	
	

}
