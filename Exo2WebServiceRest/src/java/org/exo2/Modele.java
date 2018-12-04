/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

import java.util.ArrayList;

/**
 *
 * @author guillaume
 */
public class Modele {
    private ArrayList<Book> myBooks;
    private ArrayList<Borrow> myBorrows;
    private ArrayList<Customer> myCustomers;
    
    public Modele(){
        this.myBooks = new ArrayList<Book>();
        this.myBorrows = new ArrayList<Borrow>();
        this.myCustomers = new ArrayList<Customer>();
    }
    
    public void addBook(Book book){
        this.myBooks.add(book);
    }
    
    public void addBorrow(Borrow borrow){
        this.myBorrows.add(borrow);
    }
    
    public void addCustomer(Customer customer){
        this.myCustomers.add(customer);
    }
    
    public String toXML(){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        toReturn += "<bibliotheque>";
        for(Book b : myBooks)
            toReturn += b.toXML();
        for(Borrow bo : myBorrows)
            toReturn += bo.toXML();
        for(Customer c : myCustomers)
            toReturn += c.toXML();
        toReturn += "</bibliotheque>";
        
        return toReturn;
    }
    
    
}
