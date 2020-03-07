package com.kalwador.security.resource;

import com.kalwador.security.commons.EnableCommons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCommons
@SpringBootApplication
public class ResourceMain {
    public static void main(String[] args) {
        SpringApplication.run(ResourceMain.class, args);
    }
}
