package com.mycompany.app;

import java.util.Scanner;

public class Bookstore {
	
	private static Booklist catalogue = new Booklist();
	private static Cart cart = new Cart();
    private static final String EXIT_SUCCESS = "0";
    private static final String exit_phrase = "Thank you for using Daintree!";
    private static final String search_phrase = "Enter title for search: ";
    private static final String invalid_number = "Sorry, that is an invalid option!";
  //  private static final String invalid_general = "Please enter as the prompt requires.";
    private static final String no_match = "There is no title starting with that.";
    private static final String no_copies = "There are no physical copies available.";
    private static final String asEbook = "Do you want to buy this as an ebook: ";
    private static final String affirmative = "YES";
    private static final String choose = "What is your selection: ";
    private static final String cart_empty = "Your cart is empty.";
	    
    public static void main(String[] args) {
 	        initCatalogue();
            Scanner input = new Scanner(System.in);
            int numberInput = -1;
            double total = 0;
            String wordInput = "";
            while (numberInput != Integer.parseInt(EXIT_SUCCESS) && !wordInput.equals(EXIT_SUCCESS)){
                printMenu();
                //try {
                numberInput = input.nextInt();
                switch(numberInput) {
                //Add book to cart
                    case 1:  System.out.println(search_phrase);
                                wordInput = input.next().toString();
                                Booklist matches = catalogue.searchMatch(wordInput);
                                if(matches.getbookList().length == 0){
                                    System.out.println(no_match);
                                } else {
                                    matches.printBooklist();
                                    System.out.println(choose);
                                    numberInput = input.nextInt();
                                    if(numberInput > 0 && numberInput <= matches.getbookList().length) {
	                                    Book newBook = matches.getbookList()[numberInput - 1];
                                    	System.out.println(asEbook);
	                                    wordInput = input.next().toString();
	                                    if(wordInput.toUpperCase().contains(affirmative)){
	                                        cart.addEbook(newBook);
	                                    } else {
	                                    	if(newBook.getNumberAvailable() > 0) {
	                                    		cart.addBook(newBook);
	                                    		System.out.println(newBook.getTitle() + " was successfully added to your cart.\n");
	                                    	} else {
	                                    		System.out.println(no_copies);
	                                    	}
	                                    }
                                    } else {
                                    	System.out.print(invalid_number);
                                    }
                                }
                                break;
                    //View cart
                    case 2:		if (cart.getbookList()[0].getTitle().isEmpty()) {
                    				System.out.println(cart_empty);
                    			 } else {
                    				cart.printBooklist();
                    			 }
                                break;
                    //Remove book
                    case 3:  	cart.printBooklist();
                    			System.out.println(choose);
                    			numberInput = input.nextInt();
                    			if(numberInput > 0 && numberInput <= cart.getbookList().length) {
                    				cart.removeBookFromBooklist(numberInput - 1);
                    			} else {
                    				System.out.println(invalid_number);
                    			}
                                break;
                    //Checkout
                    case 4:  	if (cart.getbookList()[0].getTitle().isEmpty()) {
        							System.out.println(cart_empty);
                    			} else {
                    				System.out.println("You have purchased " + cart.quantityTotal() + "item(s) at a total of $" + cart.grandTotal());
                    				System.out.println(exit_phrase);
                    				updateCart();
                    			}
                                break;
                    //List all books
                    case 5:  	catalogue.printBooklist();
                                break;
                    case 0:  	numberInput = Integer.parseInt(EXIT_SUCCESS);
                                break;
                    default  :  System.out.println(invalid_number);
                }
            }
            // } catch(Exception e) {
            //     System.out.println(invalid_general);
            // }
            input.close();
            System.out.println(exit_phrase + "\nGoodbye!");
    }
    
    public static void initCatalogue() {
    		Book book1 = new Book("Absolute Java", "Savitch", 5, true);
	        Book book2 = new Book ("JAVA: How to Program", "Deitel & Deital", 0, true);
	        Book book3 = new Book ("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false);
	        Book book4 = new Book ("Java Software Solutions", "Lewis & Loftus", 5, false);
	        Book book5 = new Book ("Java Program Design", "Cohoon & Davidson", 1, true);
	        catalogue.addBook(book1);
	        catalogue.addBook(book2);
	        catalogue.addBook(book3);
	        catalogue.addBook(book4);
	        catalogue.addBook(book5);
    }

    public static void printMenu() {
        System.out.println("Choose an option\n" +
        "1. Add a book to shopping cart\n" +
        "2. View shopping cart\n"+
        "3. Remove a book from shopping cart\n" +
        "4. Checkout\n" +
        "5. List all books\n" +
        "0. Quit\n");
        System.out.print("Please make a selection: ");
    }
    
    public static void updateCart() {
    	for(Book book : catalogue.getbookList()) {
    		for(int i = 0; i < cart.getbookList().length; i++) {
    			if (book.getTitle().equals(cart.getbookList()[i].getTitle())) {
    				book.setNumberAvailable(book.getNumberAvailable() - cart.getQuantity(i));
    				cart.setQuantity(i, 0);
    			}
    		}
    	}
    	cart = new Cart();
    }
}
