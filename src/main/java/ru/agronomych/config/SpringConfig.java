package ru.agronomych.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan("ru.agronomych")
@EnableAsync
public class SpringConfig {
}
