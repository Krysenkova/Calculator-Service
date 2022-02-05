package com.example.calculatorservice;

import com.example.calculatorservice.calculator.CalculatorController;
import com.example.calculatorservice.calculator.CalculatorService;
import com.example.calculatorservice.model.Price;
import com.example.calculatorservice.model.PriceList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @MockBean
    private CalculatorService service;

    @Test
    public void calculatorControllerGoodTest() {
        List<Price> prices = new ArrayList<>();
        prices.add(new Price(1, 34.0));
        prices.add(new Price(2, 12.0));
        PriceList pl = new PriceList(prices);
        when(service.calculatePrice(prices)).thenReturn(pl);
        CalculatorController cc = new CalculatorController(service);
        Assertions.assertEquals(pl, cc.calculatePrice(pl.getPriceList()));
    }
}
