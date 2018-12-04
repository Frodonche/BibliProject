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
    private static Modele INSTANCE = new Modele();
    private ArrayList<Book> myBooks;
    private ArrayList<Borrow> myBorrows;
    private ArrayList<Customer> myCustomers;
    
    public Modele(){
        this.myBooks = new ArrayList<Book>();
        this.myBorrows = new ArrayList<Borrow>();
        this.myCustomers = new ArrayList<Customer>();
    }
    
    public static Modele getInstance(){
        return INSTANCE;
    }
    
    public void addBook(Book book){
        Book tmp = searchBook(book.getIsbn());
        if(tmp == null){
            this.myBooks.add(book);
        }else{
            tmp.setQuantite(tmp.getQuantite()+book.getQuantite());
        }
    }
    
    public void deleteBook(Book book){
        if(searchBook(book.getIsbn()) != null){
            myBooks.remove(book);
        }
    }
    
    public void updateBook(Book book){
        Book tmp = searchBook(book.getIsbn());
        if(tmp != null){
            tmp.setAuteur(book.getAuteur());
            tmp.setCategorie(book.getCategorie());
            tmp.setIsbn(book.getIsbn());
            tmp.setTitre(book.getTitre());
            tmp.setQuantite(book.getQuantite());
        }
    }
    
    public void addBorrow(Borrow borrow){
        this.myBorrows.add(borrow);
    }
    
    public void addCustomer(Customer customer){
        this.myCustomers.add(customer);
    }
    
    public Book searchBook(int isbn){
        int i = 0;
        while ( i < myBooks.size()-1 ){
            if ( myBooks.get(i).getIsbn() == isbn ){
                return myBooks.get(i);
            }
            i++;
        }
        return null;
    }
    
    public Customer searchCustomer(int numero){
        int i = 0;
        while ( i < myCustomers.size()-1 ){
            if ( myCustomers.get(i).getNumero() == numero ){
                return myCustomers.get(i);
            }
            i++;
        }
        return null;
    }

}
