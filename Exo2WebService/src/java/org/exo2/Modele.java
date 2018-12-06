/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guillaume
 */
public class Modele {
    private static Modele INSTANCE = new Modele();
    private ArrayList<Book> myBooks;
    private ArrayList<Borrow> myBorrows;
    private ArrayList<Customer> myCustomers;
    private String URL = "jdbc:derby://localhost:1527/bibli";
    private String login = "";
    private String mdp = "";
    private Connection con ;
    private Statement stmt ;
    
    public Modele(){
        this.myBooks = new ArrayList<Book>();
        this.myBorrows = new ArrayList<Borrow>();
        this.myCustomers = new ArrayList<Customer>();
        this.logoutAll();
        try {
            con = DriverManager.getConnection(URL, login,mdp);
            stmt = con.createStatement( );
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Modele getInstance(){
        return INSTANCE;
    }
    
    public void updateBookList(){
        String SQL = "select * from books;";
        myBooks = new ArrayList<>();
        Book tmp;
        String auteur,titre,categorie;
        int quantite,isbn;
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    isbn = rs.getInt("isbn");
                    quantite = rs.getInt("quantite");
                    titre = rs.getString("titre");
                    auteur = rs.getString("auteur");
                    categorie = rs.getString("categorie");
                    tmp = new Book(isbn, titre, auteur, categorie, quantite);
                    myBooks.add(tmp);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateBorrowList(){
        String SQL = "select * from borrows;";
        myBorrows = new ArrayList<>();
        Borrow tmp;
        int id,isbn;
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    isbn = rs.getInt("isbn");
                    id = rs.getInt("idCustomer");
                    tmp = new Borrow(isbn, id);
                    myBorrows.add(tmp);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateCustomerList(){
        String SQL = "select * from customers;";
        myCustomers = new ArrayList<>();
        Customer tmp;
        int numero;
        String nom, prenom, adresse;
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    numero = rs.getInt("numero");
                    nom = rs.getString("nom");
                    prenom = rs.getString("prenom");
                    adresse = rs.getString("adresse");
                    tmp = new Customer(numero, nom, prenom, adresse);
                    myCustomers.add(tmp);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void executeRequest (String SQL){
        try { 
            stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addBookSQL(String auteur, String categorie, int isbn, int quantite, String titre){
        String SQL = "insert into books values ("+ Integer.toString(isbn) + "," + titre + "," + auteur + "," + categorie + "," + Integer.toString(quantite) + ");";
        executeRequest(SQL);
        this.updateBookList();
    }
    
    public int searchBookQuantite(int isbn){
        String SQL = "select * from books where isbn='"+Integer.toString(isbn)+"';";
        int qte=0;
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    qte = rs.getInt("quantite");
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qte;
    }
    
    public void updateBookQuantite(int isbn, int qte){
        int qte_exist = searchBookQuantite(isbn);
        qte = qte + qte_exist;
        String SQL = "update books set quantite = '" + qte + "' where isbn = '"+isbn+"';";
        executeRequest(SQL);
        this.updateBookList();
    }
    
    public boolean existBook(int isbn){
        String SQL = "select * from books where isbn='"+Integer.toString(isbn)+"';";
        int qte=0;
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    qte++;
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(qte>0)return true;
        return false;
    }

    public void addBook(String auteur, String categorie, int isbn, int quantite, String titre){
        
        if(!existBook(isbn)){
            addBookSQL(auteur, categorie, isbn, quantite, titre);
        }else{
            updateBookQuantite(isbn,quantite+searchBookQuantite(isbn));
        }
        this.updateBookList();
    }
    
    public void deleteBook(int isbn){
        if(existBook(isbn)){
            String SQL = "DELETE FROM books WHERE isbn = '"+isbn+"';";
            executeRequest(SQL);
            this.updateBookList();
        }
    }
    
    public void updateBook(String auteur, String categorie, int isbn, int quantite, String titre){
        Book tmp = searchBook(isbn);
        if(existBook(isbn)){
            String SQL = "update books "
                    + "set quantite = '" + quantite +"' , "
                    + "categorie = '"+categorie+"' ,"
                    + "titre = '" + titre +"' ,"
                    + "auteur = '" + auteur +"' ,"
                    + "' where isbn = '"+isbn+"';";
            executeRequest(SQL);
            this.updateBookList();
        }
    }
      
    public void deleteBorrow(int isbn, int idCustomer){
        String SQL = "delete from borrows where isbn = '"+Integer.toString(isbn)+"' and idcustomer = '"+Integer.toString(idCustomer)+"';";
        if(this.borrowExist(isbn, idCustomer)){
            upBook(isbn);
        }
        this.executeRequest(SQL);
        this.updateBorrowList();
        
    }
    public boolean upBook(int isbn){
        Book tmp = searchBook(isbn);
        if(existBook(isbn)){
            int quantite = this.searchBookQuantite(isbn);
            quantite += 1;
            String SQL = "update books "
                    + "set quantite = '" + quantite +"';";
            this.executeRequest(SQL);
            this.updateBookList();
            return true;
        }
        return false;
    }
    
    
    public boolean reduceBook(int isbn){
        Book tmp = searchBook(isbn);
        if(existBook(isbn) && this.searchBookQuantite(isbn) > 0){
            int quantite = this.searchBookQuantite(isbn);
            quantite -= 1;
            String SQL = "update books "
                    + "set quantite = '" + quantite +"';";
            this.executeRequest(SQL);
            this.updateBookList();
            return true;
        }
        return false;    }
    
    public int countBorrowsByCustomer(int id){
        int count=0;
        for(Borrow b : myBorrows){
            if(b.getNumCustomer()==id)count++;
        }
        return count;
    }
    
    public boolean borrowExist(int isbn, int idCustomer){
        String SQL = "select * from borrows;";
        boolean ret = false;
        try { 
            int isbnTmp, idTmp;
            ResultSet rs = stmt.executeQuery( SQL );
                while ( rs.next( ) ) {
                    isbnTmp = rs.getInt("isbn");
                    idTmp = rs.getInt("idcustomer");
                    if(isbnTmp == isbn && idCustomer == idTmp)ret=true;
                } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public void addBorrow(int isbn, int idCustomer){
        if(!this.borrowExist(isbn, idCustomer)){
            String SQL = "insert into borrows values ("+Integer.toString(isbn)+","+Integer.toString(idCustomer)+");";
            this.executeRequest(SQL);
            this.reduceBook(isbn);
        }
    }
    
    public boolean existCustomer(Customer c){
        boolean ret = false ;
        String SQL = "select * from customers where numero='"+Integer.toString(c.getNumero())+"';";
        try { 
            ResultSet rs = stmt.executeQuery( SQL );
            while ( rs.next( ) ) {
                ret = true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public void addCustomer(Customer customer){
        if(!this.existCustomer(customer)){
            String SQL = "insert into customers values("+
                    Integer.toString(customer.getNumero())+","+
                    customer.getNom()+","+
                    customer.getPrenom()+","+
                    customer.getAdresse()+");";
            this.executeRequest(SQL);
            this.updateCustomerList();
        }
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
    
    public String getBooksXML(ArrayList<Book> myList){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        for(Book b : myList)
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
    
    public String getBooksJSON(ArrayList<Book> myList){
        int cpt = 0;
        String toReturn = "{";
     
        if(myList.size() > 0){
            toReturn += "\"books\":[";
            
            for(Book b : myList){
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
        for(Book b: myBooks){
            if(b.getIsbn() == isbn){
                return b;
            }
        }
        return null;
    }
    
    public Customer searchCustomer(int numero){
        for(Customer c: myCustomers){
            if(c.getNumero() == numero){
                return c;
            }
        }
        return null;
    }
    
    
    public void deleteCustomer(int numero){
        String SQL = "delete from customers where numero ='"+numero+"';";
        this.executeRequest(SQL);
        this.updateCustomerList();
    }
    
    public void updateCustomer(Customer c){
        if(this.existCustomer(c)){
            String SQL = "update customers set nom = '"+c.getNom()+"',"+
                    "prenom = '"+c.getPrenom()+"',"+
                    "adresse = '"+c.getAdresse()+"';";
            this.executeRequest(SQL);
            this.updateCustomerList();
        }
    }
    public void logoutAll(){
        for(Customer c : myCustomers)
            c.logout();
    }

    public ArrayList<Book> searchBookAuteur(String auteur){
        ArrayList<Book> books = new ArrayList<>();
        for(Book b: myBooks){
            if(b.getAuteur().equals(auteur)){
                books.add(b);            
            }
        }
        return books;
    }
    public ArrayList<Book> searchBookTitre(String titre){
        ArrayList<Book> books = new ArrayList<>();
        for(Book b: myBooks){
            if(b.getTitre().equals(titre)){
                books.add(b);            
            }
        }
        return books;
    }
    public ArrayList<Book> searchBookCategorie(String categorie){
        ArrayList<Book> books = new ArrayList<>();
        for(Book b: myBooks){
            if(b.getCategorie().equals(categorie)){
                books.add(b);            
            }
        }
        return books;
    }
}
