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


   /*
   *
    /**
     * Checks if event is aired on particular <code>dateTime</code> and assigns
     * auditorium to it.
     *
     * @param dateTime
     *            Date and time of aired event for which to assign
     * @param auditorium
     *            Auditorium that should be assigned
     * @return <code>true</code> if successful, <code>false</code> if event is
     *         not aired on that date
     */
    /*public boolean assignAuditorium(LocalDateTime dateTime, Auditorium auditorium) {
        if (airDates.contains(dateTime)) {
            auditoriums.put(dateTime, auditorium);
            return true;
        } else {
            return false;
        }
    }*/

    /**
     * Removes auditorium assignment from event
     *
     * @param dateTime
     *            Date and time to remove auditorium for
     * @return <code>true</code> if successful, <code>false</code> if not
     *         removed
     */
   /* public boolean removeAuditoriumAssignment(LocalDateTime dateTime) {
        return auditoriums.remove(dateTime) != null;
    }*/

    /**
     * Add date and time of event air
     *
     * @param dateTime
     *            Date and time to add
     * @return <code>true</code> if successful, <code>false</code> if already
     *         there
     */
    /*public boolean addAirDateTime(LocalDateTime dateTime) {
        return airDates.add(dateTime);
    }*/

    /**
     * Adding date and time of event air and assigning auditorium to that
     *
     * @param dateTime
     *            Date and time to add
     * @param auditorium
     *            Auditorium to add if success in date time add
     * @return <code>true</code> if successful, <code>false</code> if already
     *         there
     */
    /*public boolean addAirDateTime(LocalDateTime dateTime, Auditorium auditorium) {
        boolean result = airDates.add(dateTime);
        if (result) {
            auditoriums.put(dateTime, auditorium);
        }
        return result;
    }*/

    /**
     * Removes the date and time of event air. If auditorium was assigned to
     * that date and time - the assignment is also removed
     *
     * @param dateTime
     *            Date and time to remove
     * @return <code>true</code> if successful, <code>false</code> if not there
     */
   /* public boolean removeAirDateTime(LocalDateTime dateTime) {
        boolean result = airDates.remove(dateTime);
        if (result) {
            auditoriums.remove(dateTime);
        }
        return result;
    }*/

    /**
     * Checks if event airs on particular date and time
     *
     * @param dateTime
     *            Date and time to check
     * @return <code>true</code> event airs on that date and time
     */
    /*public boolean airsOnDateTime(LocalDateTime dateTime) {
        return airDates.stream().anyMatch(dt -> dt.equals(dateTime));
    }*/

    /**
     * Checks if event airs on particular date
     *
     * @param date
     *            Date to ckeck
     * @return <code>true</code> event airs on that date
     */
    /*public boolean airsOnDate(LocalDate date) {
        return airDates.stream().anyMatch(dt -> dt.toLocalDate().equals(date));
    }*/

    /**
     * Checking if event airs on dates between <code>from</code> and
     * <code>to</code> inclusive
     *
     * @param //from
     *            Start date to check
     * @param //to
     *            End date to check
     * @return <code>true</code> event airs on dates
     */
    /*public boolean airsOnDates(LocalDate from, LocalDate to) {
        return airDates.stream()
                .anyMatch(dt -> dt.toLocalDate().compareTo(from) >= 0 && dt.toLocalDate().compareTo(to) <= 0);
    }*/


}
