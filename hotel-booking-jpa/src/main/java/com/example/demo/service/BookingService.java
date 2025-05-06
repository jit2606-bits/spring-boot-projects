package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BookingRepository;
import com.example.demo.model.Booking;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setRoomNumber(updatedBooking.getRoomNumber());
                    booking.setCheckIn(updatedBooking.getCheckIn());
                    booking.setCheckOut(updatedBooking.getCheckOut());
                    booking.setCustomer(updatedBooking.getCustomer());
                    return bookingRepository.save(booking);
                })
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}