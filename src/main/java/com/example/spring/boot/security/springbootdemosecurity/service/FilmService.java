package com.example.spring.boot.security.springbootdemosecurity.service;

import com.example.spring.boot.security.springbootdemosecurity.model.Film;
import com.example.spring.boot.security.springbootdemosecurity.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Collection<Film> getFilms(){
        return (Collection<Film>) filmRepository.findAll();
    }
}
