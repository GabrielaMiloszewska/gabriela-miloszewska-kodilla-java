package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {
    @Test
    public void TestTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        //When
        board.getDoneList().addTask("no.1: done");
        board.getDoneList().addTask("no.2: done");
        board.getInProgressList().addTask("no.3: in progress");
        board.getInProgressList().addTask("no.4: in progress");
        board.getToDoList().addTask("no.6: to do");


        //Then
        assertEquals(1,board.getToDoList().getTasks().size());
        assertEquals(2,board.getInProgressList().getTasks().size());
        assertEquals(2,board.getDoneList().getTasks().size());
    }
}
