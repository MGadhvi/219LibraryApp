package com.sparta.mg.libraryapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class WelcomeController {

    @GetMapping("/")
    private String welcome() {
        return "../static/hello";
    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(defaultValue = "World",required = false) String name) {
        model.addAttribute("name", name);
        model.addAttribute("dateTime", LocalDateTime.now());
        return "hello";
    }
}
