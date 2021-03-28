package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for the Book Class.
 */
public class BookTest 
{
    
    @Test
    public void containsTitleTest()
    {
        String userInput1 = "java";
        String userInput2 = "am";
        
        Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	    Book book2 = new Book("JAVA: How to Program", "Deitel & Deital", 0, true);
	    Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	    Book book4 = new Book("Java Software Solutions", "Lewis & Loftus", 5, false);
	    Book book5 = new Book("Java Program Design", "Cohoon & Davidson", 1, true);
        Book empty = new Book();
        
        assertTrue(book1.containsTitle(userInput1));
        assertTrue(book2.containsTitle(userInput1));
        assertTrue(book3.containsTitle(userInput1));
        assertTrue(book4.containsTitle(userInput1));
        assertTrue(book5.containsTitle(userInput1));
        assertFalse(empty.containsTitle(userInput1));
        assertFalse(book1.containsTitle(userInput2));
        assertTrue(book2.containsTitle(userInput2));
        assertFalse(book3.containsTitle(userInput2));
        assertFalse(book4.containsTitle(userInput2));
        assertTrue(book5.containsTitle(userInput2));
        assertFalse(empty.containsTitle(userInput2));
    }

}