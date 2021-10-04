package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderWithExtraCheeseGetDescriptionAndCost() {//Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        System.out.println(theOrder.getDescription() + " costs PLN " + theOrder.getCost());

        //When
        String description = theOrder.getDescription();
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals("Pizza with tomato sauce and cheese with extra cheese", description);
        assertEquals(new BigDecimal("20.00"), cost);

    }

    @Test
    public void testTwoBasicPizzaOrderWithChefSpecialIngredientsGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ChefSpecialDecorator(theOrder);
        theOrder = new SpecialOffer(theOrder);
        theOrder = new ChefSpecialDecorator(theOrder);
        System.out.println(theOrder.getDescription() + ". Two pizzas cost PLN " + theOrder.getCost());

        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal("55.00"), cost);
    }

    @Test
    public void testBigItalianPizzaGetDescriptionAndCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ItalianDecorator(theOrder);
        theOrder = new BigPizzaDecorator(theOrder);
        System.out.println(theOrder.getDescription() + " costs PLN " + theOrder.getCost());

        //When
        String description = theOrder.getDescription();
        BigDecimal cost = theOrder.getCost();

        //Then
        assertEquals("Pizza with tomato sauce and cheese with mozzarella, sun-dried tomatoes and green olives (50 cm diameter)", description);
        assertEquals(new BigDecimal("40.00"), cost);
    }
}
