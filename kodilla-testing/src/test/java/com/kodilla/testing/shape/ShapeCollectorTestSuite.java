package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for square")
    class TestSquare {
        @Test // Test 1: sprawdzający, czy po dodaniu figury "kwadrat", znajduje się ona na liście.
        void testAddFigure() {
            //Given
            Square square = new Square();
            ShapeCollector shapeCollector = new ShapeCollector(square);

            //When
            shapeCollector.addFigure(square);

            //Then
            Assertions.assertEquals(square, shapeCollector.getFigure(0));
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "kwadrat".
        void testRemoveFigure() {
            //Given
            Square square = new Square();
            ShapeCollector shapeCollector = new ShapeCollector(square);
            shapeCollector.addFigure(square);
            //When
            shapeCollector.removeFigure(square);

            //Then
            Assertions.assertEquals(0, shapeCollector.getListSize());
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "kwadrat" z pozycji n listy.
        void testGetFigure() {
            //Given
            Square square = new Square();
            ShapeCollector shapeCollector = new ShapeCollector(square);
            shapeCollector.addFigure(square);

            //When
            shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(square, shapeCollector.getFigure(0));
        }

    }

    @Nested
    @DisplayName("Tests for circle")
    class TestCircle {
        @Test // Test 1: sprawdzający, czy po dodaniu figury "koło", znajduje się ona na liście.
        void testAddFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector(circle);

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "koło".
        void testRemoveFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector(circle);
            shapeCollector.addFigure(circle);
            //When
            shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertEquals(0, shapeCollector.getListSize());
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "koło" z pozycji n listy.
        void testGetFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector(circle);
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }

    }
    @Nested
    @DisplayName("Tests for rectangle")
    class TestRectangle {
        @Test // Test 1: sprawdzający, czy po dodaniu figury "trójkąt", znajduje się ona na liście.
        void testAddFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector(rectangle);

            //When
            shapeCollector.addFigure(rectangle);

            //Then
            Assertions.assertEquals(rectangle, shapeCollector.getFigure(0));
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "trójkąt".
        void testRemoveFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector(rectangle);
            shapeCollector.addFigure(rectangle);
            //When
            shapeCollector.removeFigure(rectangle);

            //Then
            Assertions.assertEquals(0, shapeCollector.getListSize());
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "trójkąt" z pozycji n listy.
        void testGetFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector(rectangle);
            shapeCollector.addFigure(rectangle);

            //When
            shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(rectangle, shapeCollector.getFigure(0));
        }

    }

    @Nested
    @DisplayName("Tests for showFigures method")
    class ShowFiguresMethodTest {
        @Test
            // Test 4: sprawdzający, czy po dodaniu figur "kwadrat", "koło" i "trójkąt", nazwy figur zostaną zwrócone w postaci jednego Stringa.
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector(new Square());
            ShapeCollector shapeCollector2 = new ShapeCollector(new Circle());
            ShapeCollector shapeCollector3 = new ShapeCollector(new Rectangle());

            //When
            shapeCollector.showFigures();
            shapeCollector2.showFigures();
            shapeCollector3.showFigures();

            //Then test passed
        }

    }
}
