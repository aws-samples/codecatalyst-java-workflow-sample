package com.example.calculator.restcalculator.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("I'm healthy!", HttpStatus.OK);
    }

}
