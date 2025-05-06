package com.example.demo.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    /* 
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    */ 
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
