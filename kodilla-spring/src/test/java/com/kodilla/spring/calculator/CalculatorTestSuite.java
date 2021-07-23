package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    void testCalculations(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double add = calculator.add(100,50);
        double sub = calculator.sub(100,50);
        double mul = calculator.mul(100,50);
        double div = calculator.div(100,50);

        //Then
        assertEquals(150, add,0 );
        assertEquals(50, sub,0 );
        assertEquals(5000, mul,0);
        assertEquals(2, div,0.1);
    }
}
