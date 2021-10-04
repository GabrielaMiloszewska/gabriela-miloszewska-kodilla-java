package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ItalianDecorator extends AbstractPizzaOrderDecorator {
    public ItalianDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("15.00"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with mozzarella, sun-dried tomatoes and green olives";
    }
}
