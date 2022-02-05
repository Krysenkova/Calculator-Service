package com.example.calculatorservice.calculator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Calculator {

    private final double MWST = 0.19;

    @Positive(message = "The price should be a positive value and bigger than null")
    private final Double price;

    public Calculator(Double price) {
        this.price = price;
    }

    public Double calculateMwSt() {
        return price * MWST;
    }

    public Double calculatePrice() {
        return price + calculateMwSt();
    }

    public Double getMwSt() {
        return MWST;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "MWST=" + MWST +
                ", price=" + price +
                '}';
    }
}
