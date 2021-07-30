package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library mostFrequentlyBorrowedBooks = new Library("The most frequently borrowed books in July 2020: ");

        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Wolf of the mountain", "Dylan Murphy", LocalDate.of(2003, 10, 20)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Slaves of dreams", "Phoebe Pearson", LocalDate.of(2012, 8, 10)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Obliteration of heaven", "Morgan Walsh", LocalDate.of(2001, 12, 15)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Rejecting the night", "Aimee Murphy", LocalDate.of(2015, 11, 13)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Gangsters and kings", "Ryan Talley", LocalDate.of(2007, 4, 6)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Unity without duty", "Madelynn Carson", LocalDate.of(2007, 2, 26)));
        mostFrequentlyBorrowedBooks.getBooks().add(new Book("Enemies of eternity", "Giancarlo Guerrero", LocalDate.of(2009, 10, 30)));

        System.out.println(mostFrequentlyBorrowedBooks.getName());
        System.out.println(mostFrequentlyBorrowedBooks.getBooks());

        Library clonedLibrary = null;
        try {
            clonedLibrary = mostFrequentlyBorrowedBooks.shallowCopy();
            clonedLibrary.setName("The most frequently borrowed books in June 2020: ");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = mostFrequentlyBorrowedBooks.deepCopy();
            deepClonedLibrary.setName("The most frequently borrowed books in August 2020: ");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        mostFrequentlyBorrowedBooks.getBooks().clear();

        System.out.println(mostFrequentlyBorrowedBooks.getName());
        System.out.println(mostFrequentlyBorrowedBooks.getBooks());
        System.out.println(clonedLibrary.getName());
        System.out.println(clonedLibrary.getBooks());
        System.out.println(deepClonedLibrary.getName());
        System.out.println(deepClonedLibrary.getBooks());

        //Then
        assertEquals(0, mostFrequentlyBorrowedBooks.getBooks().size());
        assertEquals(0, clonedLibrary.getBooks().size());
        assertEquals(7, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), mostFrequentlyBorrowedBooks.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), mostFrequentlyBorrowedBooks.getBooks());
    }
}