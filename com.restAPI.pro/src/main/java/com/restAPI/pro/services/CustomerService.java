package com.restAPI.pro.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restAPI.pro.entities.Customer;
import com.restAPI.pro.entities.Product;

import java.math.BigInteger;

@Component
public class CustomerService {
	
	private static List<Customer> customers = new ArrayList<>();
	
	static {
		// initialize Date
		
		Product product1 = new Product("Product_A", "OnePlus 8 Pro");
		Product product2 = new Product("Product_B", "OnePlus 8");
		Product product3 = new Product("Product_C", "OnePlus 7 Pro");
		Product product4 = new Product("Product_D", "OnePlus 7");
		Product product5 = new Product("Product_E", "OnePlus 6 Pro");
		
		Customer Elton = new Customer("Customer1", "Elton Mutunja",
				"Engineer and Developer", new ArrayList<>(Arrays
						.asList(product1, product2, product3, product4)));
		
		Customer Tony = new Customer("Customer2", "Tony Ndoro",
				"Programmer and Designer", new ArrayList<>(Arrays
						.asList(product1, product2, product3, product4)));
		
		customers.add(Elton);
		customers.add(Tony);
	} 
	
	public List<Customer> retrieveAllCustomers(){
		return customers;  
		
	}
	
	public Customer retrieveCustomer(String customerId) {
		for(Customer customer : customers) {
			if(customer.getId().equals(customerId)) {
				return customer;
			}
		}
		return null;
	}
	
	public List<Product> retrieveProducts(String customerId){
		Customer customer = retrieveCustomer(customerId);
		if (customer == null) {
			return null;
		}
		return customer.getProducts();
	}
	
	public Product retrieveProduct(String customerId, String productId) {
		Customer customer = retrieveCustomer(customerId);
		if(customer == null ) {
			return null;
		}
		return null;
	}

	
	public CustomerService() {
		
	}

	public Product addProduct(String customerId, Product newProduct) {
		Customer customer = retrieveCustomer(customerId);
		if(customer == null ) {
			return null;
		}
		return null;
	}

	/*public Product addProduct(String customerId, Product newProduct) {
		//TODO Auto-generated method stub
		return null;
	}*/

	
}
