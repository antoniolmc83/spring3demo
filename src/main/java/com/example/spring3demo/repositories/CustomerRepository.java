package com.example.spring3demo.repositories;

import com.example.spring3demo.records.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Iterable<Customer> findByName(String name);
}
