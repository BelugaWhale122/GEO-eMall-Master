package com.geo.emallmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EMallMasterApplication {

    @GetMapping("/")
    public String index(){
        return "Hello, World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EMallMasterApplication.class, args);
    }

}
