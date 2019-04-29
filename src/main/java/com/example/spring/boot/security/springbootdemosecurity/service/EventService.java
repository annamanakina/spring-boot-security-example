package com.example.spring.boot.security.springbootdemosecurity.service;


import com.example.spring.boot.security.springbootdemosecurity.model.Event;
import com.example.spring.boot.security.springbootdemosecurity.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@AllArgsConstructor
public class EventService {
    // Manages events (movie shows).
    // Event contains only basic information, like name, base price for tickets, rating (high, mid, low).
    // Event can be presented on several dates and several times within each day.
    // For each dateTime an Event will be presented only in single Auditorium.
    // save,
    // remove,
    // getById,
    // getByName,
    // getAll

    // getForDateRange(from, to) - returns events for specified date range (OPTIONAL)
    // getNextEvents(to) - returns events from now till the ‘to’ date (OPTIONAL)
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Event getByName(String title){
        return eventRepository.findByTitle(title);
    }

    public Optional<Event> getById(Long id){
        return eventRepository.findById(id);
    }


   /* private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public Collection<Event> getEvents(){
        return eventDAO.getAll();
    }

    public Collection<Event> getEventByTitle(String title){
         return eventDAO.getAll().stream()
                .filter(event -> event.getTitle().equals(title))
                .collect(toList());
    }

    public Event getEventById(int id){
        return eventDAO.getById(id);
    }

    public boolean remove(int id){
        return eventDAO.delete(id);
    }

    public boolean remove(Event event){
        return eventDAO.delete(event);
    }

    public boolean save(Event event){
        return eventDAO.create(event);
    }

   /* public Collection<Event> getEventsForDateRange(LocalDate start, LocalDate end){
    }

    public Event getNextEvents(LocalDate start, LocalDate end){
    }*/

}
