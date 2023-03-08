package com.example.springboot_01_03_quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...3");
        return "springboot is running...3";
    }
}
