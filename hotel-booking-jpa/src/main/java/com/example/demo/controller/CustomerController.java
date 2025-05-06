package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

@Controller
@RequestMapping("/customers") 
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    /*
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        //return "customers"; // customers.jsp (I will create it later)
        return "customers/list";
    }
    
    //@GetMapping("/add-customer")
    @GetMapping("/add")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        //return "customer-form"; // create customer-form.jsp later if needed
        return "customers/form";
    }

    //@PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    */
    
    @GetMapping
    public String list(Model model) {
    	model.addAttribute("customers", customerService.getAllCustomers());
    	return "customers/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
    	model.addAttribute("customer", new Customer());
    	return "customers/form";
    }

    /*
    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    */
    
    // Save with error handling
    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer, Model model) {
    	try 
    	{
	        customerService.saveCustomer(customer);
	        return "redirect:/customers";
    	} 
    	catch (DataIntegrityViolationException e) 
    	{
            model.addAttribute("error", "Email already exists or required fields are missing.");
            return "customers/form";
        }
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        //model.addAttribute("customer", customerRepo.findById(id).orElseThrow());
    	model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers/form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        //customerRepo.deleteById(id);
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}

