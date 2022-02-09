package com.example.calculatorservice.calculator;

import com.example.calculatorservice.model.Price;
import com.example.calculatorservice.model.PriceList;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotEmpty;
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
    @Operation(summary = "receives list of prices and calculates price with MwSt and send it back")
    public PriceList calculatePrice(@RequestBody @NotEmpty List<Price> prices){
        logger.trace("In calculatePrice in CalculatorController");
        return calcServ.calculatePrice(prices);
    }

}
