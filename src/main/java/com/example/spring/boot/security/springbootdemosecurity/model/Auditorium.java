package com.example.spring.boot.security.springbootdemosecurity.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Auditorium {

    @Id
    private Integer id;
    private String title;
    private Integer numberOfSeats;
    private String vipSeats;
}
