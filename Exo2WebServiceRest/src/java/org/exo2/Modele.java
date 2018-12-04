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
    
    public void addBook(String auteur, String categorie, int isbn, int quantite, String titre){
        Book tmp = searchBook(isbn);
        if(tmp == null){
            tmp = new Book(isbn,titre,auteur,categorie,quantite);
            myBooks.add(tmp);
        }else{
            tmp.setQuantite(quantite+tmp.getQuantite());
        }
    }
    
    public void deleteBook(int isbn){
        if(searchBook(isbn) != null){
            myBooks.remove(searchBook(isbn));
        }
    }
    
    public void updateBook(String auteur, String categorie, int isbn, int quantite, String titre){
        Book tmp = searchBook(isbn);
        if(tmp != null){
            tmp.setAuteur(auteur);
            tmp.setCategorie(categorie);
            tmp.setIsbn(isbn);
            tmp.setTitre(titre);
            tmp.setQuantite(quantite);
        }
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
