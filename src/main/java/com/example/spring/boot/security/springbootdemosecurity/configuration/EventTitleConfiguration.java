package com.example.spring.boot.security.springbootdemosecurity.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Component
@Configuration
@PropertySource("classpath:property/event-title.properties")
@ConfigurationProperties(prefix = "event")
@Validated
@Getter
@Setter
public class EventTitleConfiguration {
    private List<String> eventTitles;
}
