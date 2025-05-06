package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    // JpaRepository gives you all CRUD methods automatically:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
    // - count()
    // - and more...
	// Auto-implemented query method
    List<Customer> findByName(String Name);

    // Custom JPQL query
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findByEmail(String email);

    // Native SQL query
    @Query(value = "SELECT * FROM customer WHERE email = ?1", nativeQuery = true)
    Customer findByEmailNative(String email);
    
    // Custom query with INNER JOIN on booking table
    @Query("SELECT c FROM Customer c JOIN c.bookings b WHERE b.checkIn >= :startDate")
    List<Customer> findCustomersWithBookingsAfter(@Param("startDate") LocalDate startDate);
    
    // Paging support
    Page<Customer> findAll(Pageable pageable);
    
}
