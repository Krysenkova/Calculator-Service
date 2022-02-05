package com.example.calculatorservice.calculator;
import com.example.calculatorservice.model.Price;
import com.example.calculatorservice.model.PriceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/mwst")
public class CalculatorController {

    private final CalculatorService calcServ;
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    public CalculatorController(CalculatorService calcServ) {
        this.calcServ = calcServ;
    }

    @PostMapping
    public PriceList calculatePrice(@RequestBody List<Price> prices){
        logger.trace("In calculatePrice in CalculatorController");
        return calcServ.calculatePrice(prices);
    }

}
