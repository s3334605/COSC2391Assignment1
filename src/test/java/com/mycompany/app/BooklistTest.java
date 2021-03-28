package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Unit test for the Booklist Class
 **/
public class BooklistTest 
{
    public Booklist booklistTestEmpty() {
        Booklist booklist = new BookList();
        return booklist;
    }

    public Booklist booklistTestFull() {
        Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	    Book book2 = new Book("JAVA: How to Program", "Deitel & Deital", 0, true);
	    Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	    Book book4 = new Book("Java Software Solutions", "Lewis & Loftus", 5, false);
	    Book book5 = new Book("Java Program Design", "Cohoon & Davidson", 1, true);
        Book[] books = new Book[5];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        books[4] = book5;
        Booklist booklist = new Booklist();
        booklist.setBookList(books);
        return booklist;
    }

    @Test
    public void searchMatchTest() {
        
    }

    @Test
    public void addBookTest(){
        Booklist empty = booklistTestEmpty();
        Booklist full = booklistTestFull();
        Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	    Book book2 = new Book("JAVA: How to Program", "Deitel & Deital", 0, true);
	    Book book3 = new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	    Book book4 = new Book("Java Software Solutions", "Lewis & Loftus", 5, false);
	    Book book5 = new Book("Java Program Design", "Cohoon & Davidson", 1, true);
        Book empty = new Book();
        empty.addBook(book1);
        empty.addBook(book2);
        empty.addBook(book3);
        empty.addBook(book4);
        empty.addBook(book5);
        assertEquals(full.getbookList().length, empty.getbookList().length);
    }
    
}