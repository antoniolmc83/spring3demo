package com.example.spring3demo.controller;

import com.example.spring3demo.records.Customer;
import com.example.spring3demo.repositories.CustomerRepository;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerHttpController {
    private final CustomerRepository customerRepository;
    private final ObservationRegistry registry;

    public CustomerHttpController(CustomerRepository customerRepository, ObservationRegistry registry) {
        this.customerRepository = customerRepository;
        this.registry = registry;
    }

    @GetMapping("/customers")
    public Iterable<Customer> all() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/customers/{name}")
    public Iterable<Customer> byName(@PathVariable String name) {

        Assert.state(Character.isUpperCase( name.charAt(0) ), "The name must be uppercase!");

        return Observation.createNotStarted("by-name", this.registry)
                .observe( () -> customerRepository.findByName(name) );
        //return this.customerRepository.findByName( name );
    }




}
