package com.example.calculator.restcalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void testSumWithTwoIntegers() {
        String firstAdding = "2";
        String secondAdding = "3";
        String result = calculator.calculateSum(firstAdding, secondAdding);
        assertEquals(result, "5");
    }

    @Test
    public void testSumWithTwoFloats() {
        String firstAdding = "2,3";
        String secondAdding = "3,4";
        assertThrows(RuntimeException.class, () -> {
            calculator.calculateSum(firstAdding, secondAdding);
        });
    }

    @Test
    public void testSumWithOneFloatOneInteger() {
        String firstAdding = "2,3";
        String secondAdding = "3";
        assertThrows(RuntimeException.class, () -> {
            calculator.calculateSum(firstAdding, secondAdding);
        });
    }

    @Test
    public void testSumWithOneIntegerOneNaN() {
        String firstAdding = "2";
        String secondAdding = "hello";
        assertThrows(RuntimeException.class, () -> {
            calculator.calculateSum(firstAdding, secondAdding);
        });
    }

    @Test
    public void testSumWithTwoNaN() {
        String firstAdding = "world";
        String secondAdding = "hello";
        assertThrows(RuntimeException.class, () -> {
            calculator.calculateSum(firstAdding, secondAdding);
        });
    }

}
