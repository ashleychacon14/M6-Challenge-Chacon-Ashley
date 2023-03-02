package com.company.customerdataservice.controller;
import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController extends Customer{
    @Autowired
    CustomerRepository repo;

    @GetMapping("/customer")
    public List<Customer> getCustomer() {
        return repo.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {

        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer album) {
        return repo.save(album);
    }

    @PutMapping("/customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer album) {
        repo.save(album);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }
}

