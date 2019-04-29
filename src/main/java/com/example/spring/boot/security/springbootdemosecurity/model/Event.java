package com.example.spring.boot.security.springbootdemosecurity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @OneToOne
    private Film film;
    private double basePrice;

    //todo redone it
    //private NavigableSet<LocalDateTime> airDates = new TreeSet<>();

    //@ElementCollection(targetClass = Auditorium.class, fetch = FetchType.EAGER)
    //@CollectionTable(name ="event_auditoriums", joinColumns = @JoinColumn(name = "auditorium_id")) //todo может быть тут ошибка из-за названия колонки
   // @CollectionTable(name="event_auditoriums")


    /*@MapKeyColumn(name = "field_key")
    @Column(name = "auditorium")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Map<LocalDateTime, Auditorium> auditoriums;*/


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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id='").append(this.getId()).append('\'');
        sb.append("title='").append(title).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", ").append(film);
        sb.append('}');
        return sb.toString();
    }
}
