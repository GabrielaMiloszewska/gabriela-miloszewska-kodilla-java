package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent();
        Continent asia = new Continent();
        world.addContinent(europe);
        world.addContinent(asia);

        europe.addCountry(new Country("Poland", new BigDecimal ("38268000")));
        europe.addCountry(new Country("Spain", new BigDecimal ("46940000")));
        europe.addCountry(new Country("Belgium", new BigDecimal ("11460000")));
        asia.addCountry(new Country("China", new BigDecimal ("1398000000")));
        asia.addCountry(new Country("India", new BigDecimal ("1366000000")));
        asia.addCountry(new Country("South Korea", new BigDecimal ("51710000")));

        //When
        BigDecimal totalSand = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("2912378000");
        assertEquals(expectedPeopleQuantity, totalSand);

    }
}
