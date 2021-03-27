package com.mycompany.app;

public class Book {
    private String title;
    private String author;
    private int numberAvailable;
    private boolean ebookAvailable;

    public Book() {
    	title = "";
    	author = "";
    	numberAvailable = 0;
    	ebookAvailable = false;
    }
    
    public Book(String title, String author, int numberAvailable, boolean ebookAvailable) {
        this.title = title;
        this.author = author;
        this.numberAvailable = numberAvailable;
        this.ebookAvailable = ebookAvailable;
    }

    public boolean containsTitle(String userInput) {
        boolean contains = false;
        userInput = userInput.toUpperCase();
        if (title.contains(userInput)) {
            contains = true;
        }
        return contains;
    }

    public String getTitle(){
        return title;
    }

    public int getNumberAvailable(){
        return numberAvailable;
    }

    public void setNumberAvailable(int number) {
        numberAvailable = number;
    }
    
    public boolean getEbookAvailable() {
        return ebookAvailable;
    }
    
    public String toString() {
    	String bookString = new String(
    			"Title: " + title + "\n" +
    			"Author: " + author + "\n" +
    			"Number available: " + numberAvailable + "\n" +
    			"Ebook available: " + ebookAvailable + "\n");
    	return bookString;
    }
}
