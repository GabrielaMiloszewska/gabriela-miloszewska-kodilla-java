package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        //Given
        StudentHomework studentId1 = new Student1();
        StudentHomework studentId2 = new Student2();
        StudentHomework studentId3 = new Student3();
        StudentHomework studentId4 = new Student4();

        Teacher adrian = new Teacher("Adrian");
        Teacher jakub = new Teacher("Jakub");

        studentId1.selectObserver(adrian);
        studentId2.selectObserver(adrian);
        studentId3.selectObserver(jakub);
        studentId4.selectObserver(jakub);

        //When
        studentId1.addHomework("20.1 zadanie: wzorzec fasada");
        studentId1.addHomework("20.2 zadanie: wzorzec dekorator");
        studentId1.addHomework("20.3 zadanie: programowanie aspektowe w Spring Boot");
        studentId1.addHomework("20.4 zadanie: wzorzec obserwator");
        studentId2.addHomework("20.1 zadanie: wzorzec fasada");
        studentId2.addHomework("20.2 zadanie: wzorzec dekorator");
        studentId2.addHomework("20.3 zadanie: programowanie aspektowe w Spring Boot");
        studentId3.addHomework("20.1 zadanie: wzorzec fasada");
        studentId4.addHomework("20.2 zadanie: wzorzec dekorator");

        //Then
        assertEquals(7, adrian.getUpdateCount());
        assertEquals(2, jakub.getUpdateCount());
    }
}
