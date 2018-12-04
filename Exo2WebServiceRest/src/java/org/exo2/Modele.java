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
    
    public String getBooksXML(){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        for(Book b : myBooks)
            toReturn += b.toXML();
        
        return toReturn;
    }
    
    public String getBooksJSON(){
        int cpt = 0;
        String toReturn = "{";
     
        if(myBooks.size() > 0){
            toReturn += "\"books\":[";
            
            for(Book b : myBooks){
                if(cpt > 0)
                    toReturn += ",";
                else
                    cpt++;
                
                toReturn += b.toJSON();
            }
            toReturn += "]";
        }
        
        toReturn += "}";
        
        return toReturn;
    }
    
 
    public String toJSON(){
        int cpt = 0;
        String toReturn = "{";
        
       
        if(myBooks.size() > 0){
            toReturn += "\"books\":[";
            
            for(Book b : myBooks){
                if(cpt > 0)
                    toReturn += ",";
                else
                    cpt++;
                
                toReturn += b.toJSON();
            }
            toReturn += "]";
        }
        
        toReturn += ",";
        
        if(myBorrows.size() > 0){
            cpt = 0;
            toReturn += "\"borrows\":[";
            
            for(Borrow b : myBorrows){
                if(cpt > 0)
                    toReturn += ",";
                else
                    cpt++;
                
                toReturn += b.toJSON();
            }
            toReturn += "]";
        }
        
        toReturn += ",";
        
        if(myCustomers.size() > 0){
            cpt = 0;
            toReturn += "\"customers\":[";
            
            for(Customer c : myCustomers){
                if(cpt > 0)
                    toReturn += ",";
                else
                    cpt++;
                
                toReturn += c.toJSON();
            }
            toReturn += "]";
        }
        
        toReturn += "}";
        
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
    
    
    public void deleteCustomer(int numero){
        Customer c = searchCustomer(numero);
        if(c != null){            
            myCustomers.remove(c);
        }
    }
    
    public void updateCustomer(Customer c){
        Customer tmp = searchCustomer(c.getNumero());
        if(tmp != null){
            tmp.setNumero(c.getNumero());
            tmp.setNom(c.getNom());
            tmp.setPrenom(c.getPrenom());
            tmp.setAdresse(c.getAdresse());
        }
    }

}
