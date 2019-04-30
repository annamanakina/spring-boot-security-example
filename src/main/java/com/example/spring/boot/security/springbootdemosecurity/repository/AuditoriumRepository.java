package com.example.spring.boot.security.springbootdemosecurity.repository;

import com.example.spring.boot.security.springbootdemosecurity.model.Auditorium;
import org.springframework.data.repository.CrudRepository;

public interface AuditoriumRepository extends CrudRepository<Auditorium, Integer> {
    Auditorium findAuditoriumByTitle(String title);
}
