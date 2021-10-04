package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class BigPizzaDecorator extends AbstractPizzaOrderDecorator {
    public BigPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("10.00"));
    }

    public String getDescription() {
        return super.getDescription() + " (50 cm diameter)";
    }
}
