package com.kodilla.spring.calculator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public final class Display {

    public void displayValue(double val) {
        System.out.println(val);
    }
}
