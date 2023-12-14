package com.example.calculator.restcalculator.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public String calculateSum(String firstAdding, String secondAdding) {
        if (!isInteger(firstAdding) || !isInteger(secondAdding)) {
            throw new RuntimeException("Operation supports only integer numbers");
        }

        Integer result = Integer.parseInt(firstAdding) + Integer.parseInt(secondAdding);
        return String.valueOf(result);
    }

    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

}
