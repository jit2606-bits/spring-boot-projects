package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>
{
    // JpaRepository gives you all CRUD methods automatically:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
    // - count()
    // - and more...
    List<Booking> findByCustomerId(Long customerId);
    // Find bookings by a customer's name
    @Query("SELECT b FROM Booking b WHERE b.customer.name = ?1")
    List<Booking> findByCustomerName(String name);

    // Find active bookings between two dates
    @Query("SELECT b FROM Booking b WHERE b.checkIn <= ?2 AND b.checkOut >= ?1")
    List<Booking> findBookingsInDateRange(LocalDate startDate, LocalDate endDate);

    // Get all bookings with customer and room details
    @Query("SELECT b FROM Booking b JOIN FETCH b.customer JOIN FETCH b.roomNumber")
    List<Booking> fetchAllWithCustomerAndRoom();

    // Find bookings for a specific room
    @Query("SELECT b FROM Booking b WHERE b.roomNumber = ?1 ORDER BY b.checkIn ASC")
    List<Booking> findBookingsByRoomNumber(String roomNumber);

    // Count bookings per room
    @Query("SELECT b.roomNumber, COUNT(b) FROM Booking b GROUP BY b.roomNumber")
    List<Object[]> countBookingsPerRoom();
}
