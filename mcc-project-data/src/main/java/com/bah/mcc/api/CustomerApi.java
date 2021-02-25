package com.bah.mcc.api;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.mcc.domain.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerApi {
	
	List<Customer> listofCustomers = new ArrayList<Customer>();
	
	public CustomerApi() {
		Customer c1 = new Customer(1L, "Diana", "test 1", "dbohuslov@comcast.net");
		Customer c2 = new Customer(1L, "Terry", "test 1", "tbohuslov@comcast.net");
		Customer c3 = new Customer(3L, "Kerry", "test 1", "kerry@comcast.net");
		Customer c4 = new Customer(4L, "Tom", "test 1", "tom@comcast.net");
		
		this.listofCustomers.add(c1);
		this.listofCustomers.add(c2);
		this.listofCustomers.add(c3);
		this.listofCustomers.add(c4);
	}
		@GetMapping
		public List<Customer> getListCustomers(){
			return listofCustomers;
		}
		@GetMapping("/{customerId}")
		public Customer getCustomer(@PathVariable("customerId") Long id) {
			Customer myCustomer = null;
			for(Customer customer: listofCustomers) {
				if(customer.getId() == id) {
					myCustomer = customer;
				}
			}
			return myCustomer;
		}
		public void setListCustomers(ArrayList<Customer> listofCustomers) {
			this.listofCustomers = listofCustomers;
		}
		public List<Customer> getAll(){
			return this.getListCustomers();
		}
		
	}
	

