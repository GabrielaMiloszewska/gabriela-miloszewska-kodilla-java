package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void whenBothNumbersAreOutsideTheScopeOfTheException () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & then
        assertAll(
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.99, 1.49)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.00, 1.51))
        );
    }

    @Test
    void whenOneNumberIsOutsideTheScopeOfTheException () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.99, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.00, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.49)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.00, 1.51))
        );

    }

    @Test
    void whenBothNumbersAreWithinTheScopeOfTheException () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.00, 1.5))
        );

    }
}
