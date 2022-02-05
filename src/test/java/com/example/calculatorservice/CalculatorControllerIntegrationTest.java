package com.example.calculatorservice;

import com.example.calculatorservice.calculator.CalculatorController;
import com.example.calculatorservice.calculator.CalculatorService;
import com.example.calculatorservice.model.Price;
import com.example.calculatorservice.model.PriceList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void controllerTest() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        List<Price> prices = new ArrayList<>();
        prices.add(new Price(1, 34.0));
        prices.add(new Price(2, 12.0));
        List<Price> pricesMwSt = new ArrayList<>();
        pricesMwSt.add(new Price(1, 40.46));
        pricesMwSt.add(new Price(2, 14.28));
        when(calculatorService.calculatePrice(prices)).thenReturn(new PriceList(pricesMwSt));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/mwst")
                .content(asJsonString(prices))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
