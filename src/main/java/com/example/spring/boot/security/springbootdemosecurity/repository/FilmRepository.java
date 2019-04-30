package com.example.spring.boot.security.springbootdemosecurity.repository;

import com.example.spring.boot.security.springbootdemosecurity.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
