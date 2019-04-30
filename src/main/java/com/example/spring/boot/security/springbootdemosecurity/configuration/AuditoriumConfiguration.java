package com.example.spring.boot.security.springbootdemosecurity.configuration;


import com.example.spring.boot.security.springbootdemosecurity.model.Auditorium;
import com.example.spring.boot.security.springbootdemosecurity.repository.AuditoriumRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//creates a Spring bean in the application context.
@Configuration
//to define the location of our properties file
@PropertySource("classpath:property/auditorium.properties")
@ConfigurationProperties(prefix = "auditorium")
@Getter
@Setter

public class AuditoriumConfiguration implements InitializingBean {

    private List<Auditorium> auditoriums;

    private final AuditoriumRepository auditoriumRepository;

    @Autowired
    public AuditoriumConfiguration(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (auditoriums != null && !auditoriums.isEmpty()) {
            auditoriumRepository.saveAll(auditoriums);
        }
    }
}
