package com.example.spring.boot.security.springbootdemosecurity.repository;

import com.example.spring.boot.security.springbootdemosecurity.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

   Event findByTitle(String title);

}
