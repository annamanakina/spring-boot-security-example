package com.example.spring.boot.security.springbootdemosecurity.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCongiruration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
