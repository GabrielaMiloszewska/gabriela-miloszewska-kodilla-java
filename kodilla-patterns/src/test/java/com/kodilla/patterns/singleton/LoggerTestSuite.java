package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    @Test
    void testGetLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;

        //When
        String lastLog = "the last log";
        logger.getLastLog();

        //Then
        assertEquals("the last log", lastLog);
    }
}
