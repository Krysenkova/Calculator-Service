package com.example.calculatorservice.calculator;
import com.example.calculatorservice.model.Product;
import com.example.calculatorservice.model.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/vat")
public class CalculatorController {

    private final CalculatorService calcServ;
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    public CalculatorController(CalculatorService calcServ) {
        this.calcServ = calcServ;
    }

    @PostMapping
    public ResponseList calculatePrice(@RequestBody List<Product> products){
        logger.trace("In calculateMwSt in CalculatorController");
        System.out.println("products: " + products);
        return calcServ.calculatePrice(products);
    }

}
