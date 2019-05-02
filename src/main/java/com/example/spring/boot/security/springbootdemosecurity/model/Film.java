package com.example.spring.boot.security.springbootdemosecurity.model;


import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private double rating;
    private short duration;

}
