package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when given list is empty, " +
            "then exterminate method should return an appropriate message"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = exterminator.exterminate(emptyList);
        //Then
        Assertions.assertEquals(emptyList, result);
    }

    @DisplayName("when the list contains even and odd numbers, " +
            "then exterminate method should return only even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> theList = new ArrayList<>();
        for (int n=1; n < 5; n++) {
            theList.add(n);
        }
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(2);
        expectedResult.add(4);
        //When
        List<Integer> result = exterminator.exterminate(theList);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}