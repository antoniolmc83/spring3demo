package com.example.spring3demo.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.spring3demo.repositories.CustomerRepository;
@Configuration
public class AppBeans {


    @Bean
    ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(CustomerRepository customerRepository) {
        return event -> customerRepository.findAll().forEach(System.out::println);
    }

}
