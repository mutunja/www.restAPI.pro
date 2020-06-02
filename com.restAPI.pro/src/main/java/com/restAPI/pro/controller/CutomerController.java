package com.restAPI.pro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restAPI.pro.entities.Product;
import com.restAPI.pro.services.CustomerService;

@RestController
public class CutomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers/{customerId}/products")
	public List<Product> retrieveProductForCustomer(@PathVariable String customerId){
		return customerService.retrieveProducts(customerId);
		
	}
	@GetMapping("/customers/{customerId}/products/{productId}")
	public Product retrieveDetailsForProduct(@PathVariable String customerId,
		@PathVariable String productId){
			return customerService.retrieveProduct(customerId, productId);
			
	}
	@PostMapping("/customers/{customerId}/products")
	public ResponseEntity<Void> registerCustomerForProducts(
			@PathVariable String customerId, @RequestBody Product newProduct){
		
		Product product = customerService.addProduct(customerId, newProduct);
		
		if(product == null)
			
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(product.getId()).toUri();
		return null;
	}
	


}
