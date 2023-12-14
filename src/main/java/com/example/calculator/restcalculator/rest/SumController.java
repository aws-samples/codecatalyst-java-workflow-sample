package com.example.calculator.restcalculator.rest;

import com.example.calculator.restcalculator.dto.ResultDto;
import com.example.calculator.restcalculator.dto.SumDto;
import com.example.calculator.restcalculator.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @Autowired
    private Calculator calculator;

    @PostMapping("/sum")
    public ResultDto sum(@RequestBody SumDto sumDto) {
        String result = calculator.calculateSum(sumDto.getFirstAdding(), sumDto.getSecondAdding());
        ResultDto resultToBeReturned = new ResultDto();
        resultToBeReturned.setResult(result);
        return resultToBeReturned;
    }

}
