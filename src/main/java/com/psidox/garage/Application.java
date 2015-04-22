package com.psidox.garage;

import com.psidox.garage.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }


}
