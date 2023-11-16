package org.example.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;

@SpringBootApplication
public class QuotationApplication {

    @Bean
    public ZoneId zoneId() {
        return ZoneId.systemDefault();
    }

    public static void main(String[] args) {
        SpringApplication.run(QuotationApplication.class, args);
    }
}
