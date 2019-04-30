package com.example.spring.boot.security.springbootdemosecurity.service;

import com.example.spring.boot.security.springbootdemosecurity.model.Auditorium;
import com.example.spring.boot.security.springbootdemosecurity.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    private Set<Integer> vipSeats;
    private Auditorium auditorium;

    @Autowired
    public AuditoriumService(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    public Collection<Auditorium> getAuditoriums(){
        return (Collection<Auditorium>) auditoriumRepository.findAll();
    }

    public Auditorium getByName(String title){
       return auditoriumRepository.findAuditoriumByTitle(title);
    }

    /*public Set<Integer> getAllSeats() {
        return IntStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }*/

    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    public long countVipSeats(Collection<Integer> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }
}
