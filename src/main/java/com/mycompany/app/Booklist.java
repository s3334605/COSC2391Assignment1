package com.mycompany.app;

public class Booklist {
	
	private Book[] bookList;

    public Booklist() {
        bookList = new Book[1];
        bookList[0] = new Book();
    }
    
    public Book[] getbookList() {
    	return bookList;
    }

    public void addBook(Book newBook) {
    	if (bookList[0].getTitle().isEmpty()) {
    		bookList[0] = newBook;
    	} else {
	        Book[] newbookList = new Book[bookList.length + 1];
	        for (int i = 0; i < bookList.length; i++) {
	            newbookList[i] = bookList[i];
	        }
	        bookList = newbookList;
	        bookList[bookList.length - 1] = newBook;
    	}
    }

    public void removeBookFromBooklist(int selection) {
        int addCount = 0;
        int index = 0;
        if (bookList.length > 1) {
            Book[] newbookList = new Book[bookList.length - 1];
            bookList[selection - 1] = new Book();
            for (Book book:bookList) {
                if(!book.getTitle().isEmpty()){
                newbookList[addCount] = bookList[index];
                addCount++;
                } 
                index++;
            }
            bookList = newbookList;
        } else {
            bookList = new Book[1];
        }
    }
    
    public Book getBook(int index) {
    	return bookList[index];
    }
    
    public Booklist searchMatch(String input) {
        Booklist matches = new Booklist();
        input = input.toUpperCase();
        for(Book book:bookList) {
            if(book.getTitle().toUpperCase().contains(input)) {
                matches.addBook(book);
            }
        }
        return matches;
    }

    public int searchIndex(String title) {
        int searchIndex = -1;
        int index = 0;
        title = title.toUpperCase();
        for(Book book: bookList) {
            if(title.equals(book.getTitle().toUpperCase())){
                searchIndex = index;
            }
            index++;
        }
        return searchIndex;
    }

    public void printBooklist() {
        int index = 1;
        for(Book book:bookList) {
            System.out.println(index + ". " + book.getTitle());
            index++;
        }
    }
}
