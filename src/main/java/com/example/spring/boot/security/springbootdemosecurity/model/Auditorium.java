package com.example.spring.boot.security.springbootdemosecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Validated
@Component
//todo ???
//@Configuration
@PropertySource("classpath:property/auditorium.properties")
@ConfigurationProperties(prefix = "auditorium")
public class Auditorium {

    //@Value("${conf['auditorium.cache']}")
    //https://stackoverflow.com/questions/12576156/reading-a-list-from-properties-file-and-load-with-spring-annotation-value
    @Id
    @Value("${auditorium.auditoriums[0].id}") //@Value("#{'${Quest}'.split(',')}")
    private String id;
    @Value("${auditorium.auditoriums[0].title}")
    private String title;
    @Value("${auditorium.auditoriums[0].numberOfSeats}")//${auditoriums:numberOfSeats}
    private String numberOfSeats;

    //or @Value("${maxVal}")
    /*@Value("#{'${auditorium.vipSeats}'.split(',')}")
    private Set<Integer> vipSeats;

    public Set<Integer> getAllSeats() {
        return IntStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }

    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    public long countVipSeats(Collection<Integer> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auditorium{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", numberOfSeats=").append(numberOfSeats);
        sb.append(", vipSeats=").append(vipSeats);
        sb.append('}');
        return sb.toString();
    }*/
}
