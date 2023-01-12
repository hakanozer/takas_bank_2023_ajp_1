package com.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Days1Application {

    public static void main(String[] args) {
        SpringApplication.run(Days1Application.class, args);
    }

}
