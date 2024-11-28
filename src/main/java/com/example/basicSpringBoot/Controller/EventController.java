package com.example.basicSpringBoot.Controller;

import com.example.basicSpringBoot.Entities.Event;
import com.example.basicSpringBoot.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A REST-controller for the Event-entity.
 *
 * @author viadukt
 * @version 1.0
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    // List all events in the table.
    @GetMapping("/getEvents")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    // Add a new event to the table.
    @PostMapping("/postEvent")
    public void addEvent(@RequestBody Event event) {
        eventRepository.save(event);
    }

    // Substract the amount given in the body from the amount stored in the database and update the new entry.
    @PutMapping("/putEvent/{id}")
    public ResponseEntity<Event> updateTicketsLeft(@PathVariable Long id, @RequestBody int amountToBuy) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        if(event.getTicketsLeft() >= amountToBuy) {
            event.setTicketsLeft(event.getTicketsLeft()-amountToBuy);
        }
        Event updatedEvent = eventRepository.save(event);
        return ResponseEntity.ok(updatedEvent);
    }

}
