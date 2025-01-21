package com.jpa.example.SpringBootWithJPA.service;

import com.jpa.example.SpringBootWithJPA.Entity.Customer;
import com.jpa.example.SpringBootWithJPA.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public String saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return "success";
    }

    public List<Customer> getCustomerList() {
       return (List<Customer>) customerRepository.findAll();
    }

    public List<Customer> getCustomerByName(String name) {

        return customerRepository.getCustomerByName(name);
    }
}
