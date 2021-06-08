package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] numbers = new int[20];
        numbers[0] = 2;
        numbers[1] = 4;
        numbers[2] = 6;
        numbers[3] = 8;
        numbers[4] = 10;
        numbers[5] = 12;
        numbers[6] = 14;
        numbers[7] = 16;
        numbers[8] = 18;
        numbers[9] = 20;
        numbers[10] = 22;
        numbers[11] = 24;
        numbers[12] = 26;
        numbers[13] = 28;
        numbers[14] = 30;
        numbers[15] = 32;
        numbers[16] = 34;
        numbers[17] = 36;
        numbers[18] = 38;
        numbers[19] = 40;

        //When
        double averageNumber = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(21.0, averageNumber,0.001);

    }
}
