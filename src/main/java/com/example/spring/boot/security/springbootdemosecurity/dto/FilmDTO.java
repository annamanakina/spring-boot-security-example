package com.example.spring.boot.security.springbootdemosecurity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class FilmDTO {

    private Long id;
    private String title;
    private double rating;
    private short duration;
}
