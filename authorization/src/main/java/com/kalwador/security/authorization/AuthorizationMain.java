package com.kalwador.security.authorization;

import com.kalwador.security.commons.EnableCommons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCommons
@SpringBootApplication
public class AuthorizationMain {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizationMain.class, args);
    }
}
