package com.example.calculatorservice;

import com.example.calculatorservice.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void calculateMwStTestRight(){
        calculator = new Calculator(10.0);
        Double vat = calculator.calculateMwSt();
        Assertions.assertEquals(1.9, vat);
    }

    @Test
    public void calculateMwStTestWrong(){
        calculator = new Calculator(9.0);
        Double vat = calculator.calculateMwSt();
        Assertions.assertNotEquals(1.0, vat, 0.0);
    }

    @Test
    public void calculatePriceTestRight(){
        calculator = new Calculator(15.0);
        Double result = calculator.calculatePrice();
        Assertions.assertEquals(17.85, result);
    }

    @Test
    public void calculatePriceTestWrong(){
        calculator = new Calculator(10.0);
        Double result = calculator.calculatePrice();
        Assertions.assertNotEquals(10.0, result);
    }

}
