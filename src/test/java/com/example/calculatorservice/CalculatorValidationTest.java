package com.example.calculatorservice;

import com.example.calculatorservice.calculator.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorValidationTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void calculatorTestPositive() {
        Calculator calculator = new Calculator(15.0);
        Set<ConstraintViolation<Calculator>> violations = validator.validate(calculator);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void calculatorTestNegative() {
        Calculator calculator = new Calculator(-5.0);
        Set<ConstraintViolation<Calculator>> violations = validator.validate(calculator);
        assertFalse(violations.isEmpty());
        ConstraintViolation<Calculator> violation = violations.iterator().next();
        assertEquals("The price should be a positive value and bigger than null", violation.getMessage());
        System.out.println(violations);
    }

    @Test
    public void calculatorTestNull() {
        Calculator calculator = new Calculator(0.0);
        Set<ConstraintViolation<Calculator>> violations = validator.validate(calculator);
        assertFalse(violations.isEmpty());
        ConstraintViolation<Calculator> violation = violations.iterator().next();
        assertEquals("The price should be a positive value and bigger than null", violation.getMessage());
        System.out.println(violations);
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }
}
