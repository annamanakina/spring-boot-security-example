package com.example.spring.boot.security.springbootdemosecurity.controller;

import com.example.spring.boot.security.springbootdemosecurity.dto.FilmDTO;
import com.example.spring.boot.security.springbootdemosecurity.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {
    private static final String FILMS_PAGE = "event/films";
    private static final String FILM_PAGE = "event/film";
    private static final String FILM_DTO = "filmDTO";
    private static final String FILMS = "films";

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String getFilms(Model model) {
        model.addAttribute(FILM_DTO, new FilmDTO());
        model.addAttribute(FILMS, filmService.getFilms());
        return FILMS_PAGE;
    }

    @PostMapping
    public String createFilm(@ModelAttribute("filmDTO") FilmDTO filmDTO, Model model) {
        filmService.create(filmDTO);
        model.addAttribute(FILMS, filmService.getFilms());
        return FILMS_PAGE;
    }

    @GetMapping("/{id}")
    public String deleteFilm(@ModelAttribute("filmDTO") FilmDTO filmDTO, Model model) {
        filmService.delete(filmDTO);
        model.addAttribute(FILMS, filmService.getFilms());
        return FILMS_PAGE;
    }

    @GetMapping("/film/{id}")
    public String getFilm(@PathVariable Long id, Model model) {
        model.addAttribute(FILM_DTO, filmService.getFilmById(id));
        return FILM_PAGE;
    }

    @PostMapping("/film/{id}")
    public String updateFilm(@ModelAttribute("filmDTO") FilmDTO filmDTO, Model model) {
        filmService.update(filmDTO);
        model.addAttribute(FILM_DTO, filmDTO);
        return FILM_PAGE;
    }

}
