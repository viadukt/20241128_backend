package com.example.basicSpringBoot.Entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The Booking-entity which generates a table to store bookings.
 *
 * @author viadukt
 * @version 1.0
 */
@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dateOfPurchase;
    private String name;
    private String date;
    private int amountToBuy;
}
