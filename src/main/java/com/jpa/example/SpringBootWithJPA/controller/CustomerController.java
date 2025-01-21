package com.jpa.example.SpringBootWithJPA.controller;

import com.jpa.example.SpringBootWithJPA.Entity.Customer;
import com.jpa.example.SpringBootWithJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/CustomerController")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/customer")
    public String saveDepartment(@Valid @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    /**
     * Handles GET requests to fetch the list of all departments.
     * @return a list of department entities
     */
    @GetMapping("/getCustomer")
    public List<Customer> getCustomer() {
        return customerService.getCustomerList();
    }

    @GetMapping("/getCustomerByName/{name}")
    public ResponseEntity<List<Customer>> getCustomerWithName(@PathVariable String name) {
        try{
            List<Customer> customerByName = customerService.getCustomerByName(name);
            return new ResponseEntity<>(customerByName, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("try again",null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
