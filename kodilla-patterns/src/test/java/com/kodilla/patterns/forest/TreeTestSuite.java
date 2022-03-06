package com.kodilla.patterns.forest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTestSuite {
    @Test
    void testLeafInfo() {
        //Given
        Tree pine = new Conifer("Pine");
        Tree oak = new LeafyTree("Oak");

        //When
        String pineInfo = pine.leafInfo();
        System.out.println(pineInfo);
        String oakInfo = oak.leafInfo();
        System.out.println(oakInfo);

        //Then
        assertEquals("The tree has green needles all year long", pineInfo);
        assertEquals("During winter the tree does not have leaves", oakInfo);
    }

    @Test
    void testGrowYourTree() {
        //Given
        Tree fir = new Conifer("Fir");
        Tree oak = new LeafyTree("Oak");

        //When
        int firWeeklyGrow = fir.growYourTree(1, 3);
        int oakWeeklyGrow = fir.growYourTree(20, 8);

        //Then
        assertEquals(1, firWeeklyGrow);
        assertEquals(3, oakWeeklyGrow);
    }

    @Test
    void testGetNameMethod() {
        //Given
        Tree fir = new Conifer("Fir");

        //When
        String name = fir.getName();

        //Then
        assertEquals("Fir", name);
    }

    @Test
    void testWhetherAmountOfWaterIsSufficient() {
        //Given
        LeafyTree oak = new LeafyTree("Oak");
        int[] arr = {10, 12, 7, 9, 10, 2};

        //When
        int plotsNumber = oak.ifAmountOfWaterIsSufficient(8, 4, arr, 6);

        //Then
        assertEquals(4, plotsNumber);                // water in first 4 plots is sufficient for all the trees
    }

    @Test
    void testOfTheEstimatedTrunkHeight() {
        //Given
        Tree pine = new Conifer("Pine");
        Tree oak = new LeafyTree("Oak");

        //When
        int pineHeight = pine.getEstimatedTrunkHeight(5);
        int oakHeight = oak.getEstimatedTrunkHeight(5);

        //Then
        assertEquals(250, pineHeight);
        assertEquals(350, oakHeight);
    }

    @Test
    void testOfTheAvgBranchLength() {
        //Given
        Tree fir = new Conifer("Fir");
        Tree oak = new LeafyTree("Oak");

        //When
        int pineBranchLen = fir.getAvgBranchLength(10);
        int oakBranchLen = oak.getAvgBranchLength(10);

        //Then
        assertEquals(20, pineBranchLen);
        assertEquals(50, oakBranchLen);
    }

    @Test
    void testOfTheAvgTrunkCircumference() {
        //Given
        Tree pine = new Conifer("Pine");
        Tree oak = new LeafyTree("Oak");

        //When
        double pineCir = pine.getAvgTrunkCircumference(6);
        double oakCir = oak.getAvgTrunkCircumference(6);

        //Then
        assertEquals(37.69, pineCir, 0.01);
        assertEquals(37.69, oakCir, 0.01);
    }
}
