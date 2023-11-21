package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


@Configuration
@ImportResource("classpath:application.xml")
// @ComponentScan(basePackages = "com.example.demo")
// @Component
public class BeanConfig {
    @Bean
    public Game game(){
        return new Game();
    }
    // @Bean
    // public String bean1(){
    //     return new String("Bean 1");
    // }
    
}
