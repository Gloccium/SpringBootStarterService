package com.demo.starterdemoapp;

import com.example.greeting.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final GreetingService greetingService;


    public DemoController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greetSomeone(@RequestParam(defaultValue = "World") String name) {
        return greetingService.greet(name);
    }
}