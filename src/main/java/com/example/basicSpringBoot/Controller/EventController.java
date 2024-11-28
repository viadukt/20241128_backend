package com.example.basicSpringBoot.Controller;

import com.example.basicSpringBoot.Entities.Event;
import com.example.basicSpringBoot.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/getEvents")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("/postEvent")
    public void addEvent(@RequestBody Event event) {
        eventRepository.save(event);
    }

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
