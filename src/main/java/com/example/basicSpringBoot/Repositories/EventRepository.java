package com.example.basicSpringBoot.Repositories;

import com.example.basicSpringBoot.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long>{
}
