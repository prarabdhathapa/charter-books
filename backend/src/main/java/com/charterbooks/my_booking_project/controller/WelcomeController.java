package com.charterbooks.my_booking_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to spring boot world, lets ee if this updates.";

    }
}
