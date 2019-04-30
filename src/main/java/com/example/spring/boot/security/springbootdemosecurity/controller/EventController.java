package com.example.spring.boot.security.springbootdemosecurity.controller;

import com.example.spring.boot.security.springbootdemosecurity.dto.EventDTO;
import com.example.spring.boot.security.springbootdemosecurity.model.Film;
import com.example.spring.boot.security.springbootdemosecurity.service.AuditoriumService;
import com.example.spring.boot.security.springbootdemosecurity.service.EventService;
import com.example.spring.boot.security.springbootdemosecurity.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private FilmService filmService;


    @GetMapping("/events")
    public String getEvents(Model model) {
        System.out.println("GetMapping getEvents");
        //filmService.getFilms().forEach(System.out::println);
        model.addAttribute("eventDTO", new EventDTO());
        model.addAttribute("films", filmService.getFilms());
        model.addAttribute("auditoriums", auditoriumService.getAuditoriums());

        return "event/events";
    }

    @PostMapping("/events")
    public String createEvent(@ModelAttribute("eventDTO") EventDTO eventDTO, Model model) {
        System.out.println("PostMapping getEvents " +eventDTO.toString());
        System.out.println(" film id: " + eventDTO.getFilm().getId());
        model.addAttribute("films", filmService.getFilms());
        model.addAttribute("auditoriums", auditoriumService.getAuditoriums());

        eventService.create(eventDTO);
        //dto in service
        //convert to entity in service (logiс) //save не создает не id,
        //


        return "event/events";
    }

}
