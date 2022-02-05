package com.example.calculatorservice.calculator;

import com.example.calculatorservice.model.Price;
import com.example.calculatorservice.model.PriceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CalculatorService {

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private Calculator calc;

    public PriceList calculatePrice(List<Price> prices) {
        logger.trace("In calculatePrice in CalculatorService");
        for (Price price : prices) {
            Double p = price.getPrice();
            calc = new Calculator(p);
            price.setPrice(calc.calculatePrice());
        }
        return new PriceList(prices);
    }

}
