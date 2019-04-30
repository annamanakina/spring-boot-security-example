package com.example.spring.boot.security.springbootdemosecurity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Setter
@Getter
//@NoArgsConstructor
@Component
public class Auditorium {

    @Id
    private Integer id;
    private String title;
    private Integer numberOfSeats;

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
