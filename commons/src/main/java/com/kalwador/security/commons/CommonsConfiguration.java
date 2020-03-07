package com.kalwador.security.commons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(value = {"com.kalwador.security.commons"})
@EntityScan(value = "com.kalwador.security.commons")
@EnableAutoConfiguration
@EnableConfigurationProperties
public class CommonsConfiguration {
}
