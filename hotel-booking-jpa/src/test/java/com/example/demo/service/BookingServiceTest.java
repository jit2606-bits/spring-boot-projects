package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    //private BookingServiceImpl bookingService;
    private BookingService bookingService;

    public BookingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookingById() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setRoomNumber("101A");
        booking.setCheckIn(LocalDate.of(2025, 5, 1));

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking result = bookingService.getBookingById(1L).orElse(null);
        assertNotNull(result);
        assertEquals("101A", result.getRoomNumber());
    }
}