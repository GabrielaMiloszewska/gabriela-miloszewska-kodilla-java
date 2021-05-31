package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionsReturnList() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOf() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOf0BooksUser1 = new ArrayList<Book>();
        List<Book> listOf1BooksUser2 = generateListOfNBooks(1);
        List<Book> listOf5BooksUser3 = generateListOfNBooks(5);
        LibraryUser libraryUser1 = new LibraryUser("adam", "kowalski", "75031798876");
        LibraryUser libraryUser2 = new LibraryUser("ewa", "kowalska", "74081767098");
        LibraryUser libraryUser3 = new LibraryUser("wojciech", "kowalski", "96081754321");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(listOf0BooksUser1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(listOf1BooksUser2);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(listOf5BooksUser3);

        // When
        List<Book> theListOf0BooksUser1 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theListOf1BooksUser2 = bookLibrary.listBooksInHandsOf(libraryUser2);
        List<Book> theListOf5BooksUser3 = bookLibrary.listBooksInHandsOf(libraryUser3);

        // Then
        assertEquals(0, theListOf0BooksUser1.size());
        assertEquals(1, theListOf1BooksUser2.size());
        assertEquals(5, theListOf5BooksUser3.size());
    }
}
