package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        Book book1 = new Book("Kahneman Daniel", "Pułapki myślenia. O myśleniu szybkim i wolnym", 2012, "1");
        Book book2 = new Book("Zaręba Dominika", "Katalonia. Barcelona, Costa Brava i Costa Dorada", 2018, "2");
        Book book3 = new Book("Murphy Joseph", "Potęga podświadomości", 2016, "3");
        Book book4 = new Book("Jerzy Sosnowski", "Wszystko zależy od przedimka", 2014, "4");
        Book book5 = new Book("Jerzy Sosnowski", "Wszystko zależy od przedimka", 2015, "5");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        //When
        int expected = medianAdapter.publicationYearMedian(bookSet);

        //Then
        System.out.println(expected);
        assertEquals(expected, 2015);
    }
}
