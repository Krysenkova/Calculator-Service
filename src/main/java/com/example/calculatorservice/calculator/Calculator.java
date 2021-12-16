package com.example.calculatorservice.calculator;

import javax.validation.constraints.Positive;

public class Calculator {

    private final double MWST = 0.19;
    private final Double price;

    public Calculator(@Positive Double price) {
        this.price = price;
    }

    public Double calculateMwSt() {
        return price * MWST;
    }
    public Double calculatePrice() {
       //TODO round till 2 signs after the comma
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
