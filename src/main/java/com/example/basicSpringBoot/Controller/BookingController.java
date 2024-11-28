package com.example.basicSpringBoot.Controller;

import com.example.basicSpringBoot.Entities.Booking;
import com.example.basicSpringBoot.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A REST-controller for the Booking-entity.
 *
 * @author viadukt
 * @version 1.0
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    // List all bookings in the table.
    @GetMapping("/getBookings")
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    // Get a certain booking from a value given in the URL-parameters.
    @GetMapping("/getBooking/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return ResponseEntity.ok(booking);
    }

    // Add a new booking to the table.
    @PostMapping("/postBooking")
    public void postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
    }

}
