package com.jpa.example.SpringBootWithJPA.repository;


import java.util.List;

import com.jpa.example.SpringBootWithJPA.Entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);


    Customer findById(long id);

    @Modifying
    @Query( value ="select * from customer where first_name =:first_name ", nativeQuery = true)
    List<Customer> getCustomerByName(@Param("first_name") String first_name);
}
