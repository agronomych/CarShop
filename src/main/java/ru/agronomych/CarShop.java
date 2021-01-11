package ru.agronomych;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
public class CarShop {

    public static void main(String[] args) {
        var application = SpringApplication.run(CarShop.class);
    }

}
