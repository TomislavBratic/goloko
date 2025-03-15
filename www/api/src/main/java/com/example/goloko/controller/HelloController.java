package com.example.goloko.controller;

import com.example.goloko.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private final GreetingService greetingService;

    // Constructor-based Dependency Injection
    public HelloController(GreetingService greetingService){
        this.greetingService = greetingService;
    }



@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.getGreeting(name);
    }
}
