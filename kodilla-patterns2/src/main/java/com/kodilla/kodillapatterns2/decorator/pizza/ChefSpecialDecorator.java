package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ChefSpecialDecorator extends AbstractPizzaOrderDecorator {
    public ChefSpecialDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("15.00"));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with ingredients selected by our Chef (gorgonzola, pear, hazelnuts, sunflower seeds, honey)";
    }
}
