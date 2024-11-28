package com.example.basicSpringBoot.Repositories;

import com.example.basicSpringBoot.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The JPA-repository for the Booking-entity.
 *
 * @author viadukt
 * @version 1.0
 */
@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
