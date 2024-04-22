package com.example.ParnellAgency.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {

    @GetMapping("/")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }
}
