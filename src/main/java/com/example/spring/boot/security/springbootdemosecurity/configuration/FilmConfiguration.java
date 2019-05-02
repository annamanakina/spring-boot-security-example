package com.example.spring.boot.security.springbootdemosecurity.configuration;

import com.example.spring.boot.security.springbootdemosecurity.model.Film;
import com.example.spring.boot.security.springbootdemosecurity.repository.FilmRepository;
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
@Configuration
@PropertySource("classpath:property/films.properties")
@ConfigurationProperties(prefix = "film")
@Getter
@Setter
public class FilmConfiguration implements InitializingBean {

    private List<Film> films;

    private final FilmRepository filmRepository;

    @Autowired
    public FilmConfiguration(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (films != null && !films.isEmpty()) {
            filmRepository.saveAll(films);
        }
    }
}
