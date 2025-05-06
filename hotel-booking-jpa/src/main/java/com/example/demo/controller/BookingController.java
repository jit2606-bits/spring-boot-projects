package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Booking;
//import com.example.demo.model.Customer;
import com.example.demo.service.BookingService;
import com.example.demo.service.CustomerService;
//import com.example.demo.repository.BookingRepository;
//import com.example.demo.repository.CustomerRepository;

@Controller
@RequestMapping("/bookings")
public class BookingController {
	/*
    @Autowired private BookingRepository bookingRepo;
    @Autowired private CustomerRepository customerRepo;
       
    @GetMapping
    public String list(Model model) {
        model.addAttribute("bookings", bookingRepo.findAll());
        return "bookings/list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("customers", customerRepo.findAll());
        return "bookings/form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Booking booking) {
        bookingRepo.save(booking);
        return "redirect:/bookings";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("booking", bookingRepo.findById(id).orElseThrow());
        model.addAttribute("customers", customerRepo.findAll());
        return "bookings/form";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookingRepo.deleteById(id);
        return "redirect:/bookings";
    }
    */
    @Autowired private BookingService bookingService;
    @Autowired private CustomerService customerService;
    
    @GetMapping
    public String list(Model model) {
    	model.addAttribute("bookings", bookingService.getAllBookings());
    	return "bookings/list";
    }
        
    @GetMapping("/add")
    public String add(Model model) {
    	model.addAttribute("booking", new Booking());
    	model.addAttribute("customers", customerService.getAllCustomers());
    	return "bookings/form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Booking booking) {
    	bookingService.saveBooking(booking);
        return "redirect:/bookings";
    }
        
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        model.addAttribute("customers", customerService.getAllCustomers());
        return "bookings/form";
    }
        
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    	bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}

