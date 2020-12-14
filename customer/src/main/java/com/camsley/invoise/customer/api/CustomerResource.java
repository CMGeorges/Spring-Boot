package com.camsley.invoise.customer.api;

import com.camsley.invoise.core.entities.customer.Customer;
import com.camsley.invoise.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @Autowired
    private CustomerRepositoryInterface customerRepository;

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long id, Model model){

        return customerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CustomerRepositoryInterface getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepositoryInterface customerRepository) {
        this.customerRepository = customerRepository;
    }
}
