package com.example.calculator.restcalculator.dto;

import java.util.Objects;

public class ResultDto {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDto resultDto = (ResultDto) o;
        return result.equals(resultDto.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "result='" + result + '\'' +
                '}';
    }
}
