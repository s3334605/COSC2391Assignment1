class Book {
    private String isbn;
    private String title;
    private Author<T> author;
    private String publisher;
    private double price;

    public Book(String isbn, String title, Author<T> author, String publisher, double Price, int numberAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public boolean containsTitle(String userInput) {
        userInput = userInput.toUpperCase();
        
    }
}

