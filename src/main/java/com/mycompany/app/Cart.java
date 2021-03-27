package com.mycompany.app;

public class Cart extends Booklist {
    private boolean[] isEbook;
    private int[] quantities;

    public Cart() {
        super();
        isEbook = new boolean[1];
        isEbook[0] = false;
        quantities = new int[1];
    }

    public void addEbook(Book book){
        addBook(book);
        isEbook[isEbook.length - 1] = true;
    }

    public void addBook(Book book) {
        int index = searchIndex(book.getTitle());
        if(index == -1) {
            super.addBook(book);
            int newLength = super.getbookList().length;
            boolean[] newIsEbook = new boolean[newLength];
            int[] newQuantity = new int[newLength];
            for (int i = 0; i < newLength; i++) {
                newIsEbook[i] = isEbook[i];
                newQuantity[i] = quantities[i];
            }
            if(newQuantity[newLength - 1] < book.getNumberAvailable()) {
	            newQuantity[newLength - 1]++;
	            quantities = newQuantity;
                isEbook[newLength - 1] = false;
            }
        } else {
        	if(quantities[index] < book.getNumberAvailable()) {
	            if (isEbook[index]) {
	                quantities[index] = 1;
	            } else {
	                quantities[index]++;
	            }
        	}
        }
    }

    public void removeBookFromBooklist(int selection) {
        if(quantities[selection] > 0) {
        super.removeBookFromBooklist(selection);
        int addCount = 0;
        int newLength = super.getbookList().length - 1;
        if (newLength > 1) {
            boolean[] newEbook = new boolean[newLength];
            int[] newQuantity = new int[newLength];
            for (int i = 0; i < newLength; i++) {
                if(i==selection){
                addCount++;
                }
                newEbook[i] = isEbook[i+addCount];
                newQuantity[i] = quantities[i+addCount];
            }
            isEbook = newEbook;
            quantities = newQuantity;
        } else {
            isEbook[0] = false;
            quantities[0] = 0;
        }
        } else {
            quantities[selection]--;
        }

    }
    
    public double grandTotal() {
    	double total = 0;
    	for(int i = 0; i < quantities.length;i++) {
    		if(isEbook[i]) {
    			total += quantities[i]*8;
    		} else {
    			total += quantities[i]*50;
    		}
    	}
    	return total;
    }
    
    public int quantityTotal() {
    	int total = 0;
    	for (int i : quantities) {
    		total += i;
    	}
    	return total;
    }

	public int getQuantity(int i) {
		return quantities[i];
	}
	
	public void setQuantity(int i, int value) {
		quantities[i] = value;
	}
}