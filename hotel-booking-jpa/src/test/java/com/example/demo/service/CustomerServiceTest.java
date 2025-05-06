package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    //private CustomerServiceImpl customerService;
    private CustomerService customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Alice");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer result = customerService.getCustomerById(1L);
        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }
}