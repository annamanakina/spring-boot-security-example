package com.example.spring.boot.security.springbootdemosecurity.dto;

import com.example.spring.boot.security.springbootdemosecurity.model.Auditorium;
import com.example.spring.boot.security.springbootdemosecurity.model.Film;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDTO{
    private String id;
    private String title;
    //private String rating;
    private Film film;
    private String airDate;
    private Auditorium auditorium;
   // private String basePrice;
}
