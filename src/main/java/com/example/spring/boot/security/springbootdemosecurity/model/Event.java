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
