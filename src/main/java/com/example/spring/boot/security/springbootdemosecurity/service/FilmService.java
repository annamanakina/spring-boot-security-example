package com.example.spring.boot.security.springbootdemosecurity.service;

import com.example.spring.boot.security.springbootdemosecurity.dto.FilmDTO;
import com.example.spring.boot.security.springbootdemosecurity.model.Film;
import com.example.spring.boot.security.springbootdemosecurity.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import static java.util.stream.Collectors.toList;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public FilmService(FilmRepository filmRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }

    public Collection<FilmDTO> getFilms(){
        return ((Collection<Film>) filmRepository.findAll()).stream()
                .map((film -> modelMapper.map(film, FilmDTO.class)))
                .collect(toList());
    }

    public Film create(FilmDTO filmDTO) {
        Film film = modelMapper.map(filmDTO, Film.class);
        filmRepository.save(film);
        return film;
    }

    public Film delete(FilmDTO filmDTO) {
        Film film = modelMapper.map(filmDTO, Film.class);
        filmRepository.delete(film);
        return film;
    }

    public FilmDTO getFilmById(Long id) {
        Film film =  filmRepository.findById(id).get();
        return modelMapper.map(film, FilmDTO.class);
    }

    public void update(FilmDTO filmDTO) {
        Film film = modelMapper.map(filmDTO, Film.class);
        filmRepository.save(film);
    }
}
