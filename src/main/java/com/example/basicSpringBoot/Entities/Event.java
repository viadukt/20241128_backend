package com.example.basicSpringBoot.Entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The Event-entity which generates a table to store events.
 *
 * @author viadukt
 * @version 1.0
 */
@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String date;
    private int ticketsLeft;
}
