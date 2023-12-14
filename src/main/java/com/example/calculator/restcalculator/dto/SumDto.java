package com.example.calculator.restcalculator.dto;

import java.util.Objects;

public class SumDto {

    private String firstAdding;
    private String secondAdding;

    public String getFirstAdding() {
        return firstAdding;
    }

    public void setFirstAdding(String firstAdding) {
        this.firstAdding = firstAdding;
    }

    public String getSecondAdding() {
        return secondAdding;
    }

    public void setSecondAdding(String secondAdding) {
        this.secondAdding = secondAdding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumDto sumDto = (SumDto) o;
        return firstAdding.equals(sumDto.firstAdding) && secondAdding.equals(sumDto.secondAdding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstAdding, secondAdding);
    }

    @Override
    public String toString() {
        return "SumDto{" +
                "firstAdding='" + firstAdding + '\'' +
                ", secondAdding='" + secondAdding + '\'' +
                '}';
    }
}
