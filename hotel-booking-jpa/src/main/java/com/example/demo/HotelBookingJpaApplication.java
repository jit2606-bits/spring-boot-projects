package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class HotelBookingJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingJpaApplication.class, args);
	}

	@Bean
    public CommandLineRunner dataLoader(CustomerRepository customerRepo, BookingRepository bookingRepo) {
        return args -> {
            Customer abi = new Customer(null, "Abhinit Sundar", "asundar@gmail.com");
            Customer bob = new Customer(null, "Bob Hulit", "bobh@yahoo.com");
            Customer charu = new Customer(null, "Charu Rao", "crao@hotmail.com");
            Customer deepak = new Customer(null, "Deepak Viswanathan", "vdeepak@yahoo.com");
            Customer elango = new Customer(null, "Elango Saravanan", "selango@gmail.com");
            Customer farhad = new Customer(null, "Farhad Irani", "firani123@gmail.com");
            Customer geetha = new Customer(null, "Geetha Sharma", "gsharma@yahoo.com");
            Customer hari = new Customer(null, "Hari Haran", "hharan@hotmail.com");
            Customer indhu = new Customer(null, "Indumathy Sinha", "sindu@gmail.com");
            Customer jay = new Customer(null, "Jay Nair", "jnair@yahoo.com");
            customerRepo.saveAll(Arrays.asList(abi, bob, charu, deepak, elango, farhad, geetha, hari, indhu, jay));

            Booking booking1 = new Booking(null, "101A", LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 5), abi);
            Booking booking2 = new Booking(null, "202B", LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 10), bob);
            Booking booking3 = new Booking(null, "200A", LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 7), charu);
            Booking booking4 = new Booking(null, "100B", LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20), deepak);
            Booking booking5 = new Booking(null, "103A", LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 20), elango);
            Booking booking6 = new Booking(null, "102A", LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 5), farhad);
            Booking booking7 = new Booking(null, "201A", LocalDate.of(2025, 3, 3), LocalDate.of(2025, 3, 10), geetha);
            Booking booking8 = new Booking(null, "203A", LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 7), hari);
            Booking booking9 = new Booking(null, "104B", LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20), indhu);
            Booking booking10 = new Booking(null, "204B", LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 20), jay);
            bookingRepo.saveAll(Arrays.asList(booking1, booking2, booking3, booking4, booking5, booking6, booking7, booking8, booking9, booking10));
        };
    }
}
