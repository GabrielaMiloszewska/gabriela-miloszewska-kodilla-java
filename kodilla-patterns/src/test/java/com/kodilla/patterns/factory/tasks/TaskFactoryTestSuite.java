package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        //Then
        assertEquals("Holiday shopping", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted(), "Holiday shopping: we bought 5 souvenirs.");

    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        //Then
        assertEquals("Holiday painting", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted(), "Holiday painting: the entire apartment was painted beige.");
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        //Then
        assertEquals("Holiday break", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted(), "Holiday break: we went to Barcelona by airplane.");
    }
}
