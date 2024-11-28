package com.example.basicSpringBoot.Repositories;

import com.example.basicSpringBoot.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The JPA-repository for the Event-entity.
 *
 * @author viadukt
 * @version 1.0
 */
@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long>{
}
