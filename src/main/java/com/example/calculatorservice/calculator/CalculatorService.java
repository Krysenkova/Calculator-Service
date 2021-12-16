package com.example.calculatorservice.calculator;

import com.example.calculatorservice.model.Product;
import com.example.calculatorservice.model.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CalculatorService {

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private Calculator calc;


    public ResponseList calculatePrice(List<Product> products) {
        logger.trace("In calculateMwSt in CalculatorService");
        for (Product product : products) {
            Double price = product.getPriceWithoutVat();
            calc = new Calculator(price);
            product.setPriceWithVat(calc.calculatePrice());
        }
        ResponseList productsWithVat = new ResponseList(products);
        return productsWithVat;
    }

}
