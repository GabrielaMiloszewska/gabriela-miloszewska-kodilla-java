package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class SpecialOffer extends AbstractPizzaOrderDecorator {
    public SpecialOffer(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("10.00"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ". Another pizza for PLN 10";
    }
}
