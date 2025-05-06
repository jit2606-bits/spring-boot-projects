package com.example.demo.controller;

//import com.example.hotel_booking_jpa.repository.BookingRepository;
//import com.example.hotel_booking_jpa.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    /* 
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;
    */
    @Test
    public void testListBookings() throws Exception {
        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk())
                .andExpect(view().name("bookings/list"));
    }
}