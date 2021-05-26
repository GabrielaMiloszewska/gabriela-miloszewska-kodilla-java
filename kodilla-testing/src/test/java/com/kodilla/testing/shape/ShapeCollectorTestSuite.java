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
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(square, expected);
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "kwadrat".
        void testRemoveFigure() {
            //Given
            Square square = new Square();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.removeFigure(square);

            //When
            int expected = shapeCollector.getListSize();

            //Then
            Assertions.assertEquals(0, expected);
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "kwadrat" z pozycji n listy.
        void testGetFigure() {
            //Given
            Square square = new Square();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(square, expected);
        }

    }

    @Nested
    @DisplayName("Tests for circle")
    class TestCircle {
        @Test // Test 1: sprawdzający, czy po dodaniu figury "koło", znajduje się ona na liście.
        void testAddFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, expected);
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "koło".
        void testRemoveFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);
            shapeCollector.removeFigure(circle);

            //When
            int expected = shapeCollector.getListSize();

            //Then
            Assertions.assertEquals(0, expected);
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "koło" z pozycji n listy.
        void testGetFigure() {
            //Given
            Circle circle = new Circle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, expected);
        }

    }

    @Nested
    @DisplayName("Tests for rectangle")
    class TestRectangle {
        @Test // Test 1: sprawdzający, czy po dodaniu figury "trójkąt", znajduje się ona na liście.
        void testAddFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(rectangle);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(rectangle, expected);
        }

        @Test // Test 2: sprawdzający, czy lista jest pusta po usunięciu figury "trójkąt".
        void testRemoveFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(rectangle);
            shapeCollector.removeFigure(rectangle);

            //When
            int expected = shapeCollector.getListSize();

            //Then
            Assertions.assertEquals(0, expected);
        }

        @Test // Test 3: sprawdzający, czy z kolekcji pobierana jest figura "trójkąt" z pozycji n listy.
        void testGetFigure() {
            //Given
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(rectangle);

            //When
            Shape expected = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(rectangle, expected);
        }

    }

    @Nested
    @DisplayName("Tests for showFigures method")
    class ShowFiguresMethodTest {
        @Test
            // Test 4: sprawdzający, czy po dodaniu figur "kwadrat", "koło" i "trójkąt", nazwy figur zostaną zwrócone w postaci jednego Stringa.
        void testShowFigures() {
            //Given
            Square square = new Square();
            Circle circle = new Circle();
            Rectangle rectangle = new Rectangle();
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(rectangle);

            //When
            shapeCollector.showFigures();

            //Then test passed
        }

    }
}
