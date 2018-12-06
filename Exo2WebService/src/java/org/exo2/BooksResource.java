/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author frlallemand
 */
@Path("books")
public class BooksResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BooksResource
     */
    public BooksResource() {
    }
        
    
    @GET
    @Path("XML/isAvailable")
    @Produces(MediaType.APPLICATION_XML)
    public String isAvailableXML(@QueryParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Book b = instance.searchBook(isbn);
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        if(b != null && b.getQuantite() > 0){
            return toReturn+"<available>true</available>";
        } else {
            return toReturn+"<available>false</available>";
        }
    }

    @GET
    @Path("JSON/isAvailable")
    @Produces(MediaType.APPLICATION_JSON)
    public String isAvailableJSON(@QueryParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Book b = instance.searchBook(isbn);
        String toReturn = "";
        if(b != null && b.getQuantite() > 0){
            return toReturn+"{\"available\" : true}";
        } else {
            return toReturn+"{\"available\" : false}";
        }
    }
    
    
    @GET
    @Path("XML/list")
    @Produces(MediaType.APPLICATION_XML)
    public String listXML() {
        Modele instance = Modele.getInstance();
        return instance.getBooksXML();
    }    
    
    @GET
    @Path("JSON/list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listJSON() {
        Modele instance = Modele.getInstance();
        return instance.getBooksJSON();
    }    
    
    
    @GET
    @Path("XML/searchByTitle")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByTitleXML(@QueryParam("titre") String title) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookTitre(title);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("JSON/searchByTitle")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByTitleJSON(@QueryParam("titre") String title) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookTitre(title);
        return instance.getBooksJSON(list);
    }   

    
    
    @GET
    @Path("XML/searchByAuthor")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByAuthorXML(@QueryParam("auteur") String author) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookAuteur(author);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("JSON/searchByAuthor")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByAuthorJSON(@QueryParam("auteur") String author) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookAuteur(author);
        return instance.getBooksJSON(list);
    }   

    @GET
    @Path("XML/searchByCategory")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByCategoryXML(@QueryParam("categorie") String categorie) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookCategorie(categorie);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("JSON/searchByCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByCategoryJSON(@QueryParam("categorie") String categorie) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookCategorie(categorie);
        return instance.getBooksJSON(list);
    }   
    
    @GET
    @Path("XML/searchByIsbn")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByIsbnXML(@QueryParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Book b = instance.searchBook(isbn);
        if(b == null) {
            String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?> ERROR: Not found";
            return toReturn;
        } else {
            return b.toXMLWithHeader();
        }
    }   
    
    @GET
    @Path("JSON/searchByIsbn")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByIsbnJSON(@QueryParam("isbn") int isbn) {
       Modele instance = Modele.getInstance();
       Book b = instance.searchBook(isbn);
       if(b == null) {
           String toReturn = "{}";
           return toReturn;
       } else {
           return b.toJSON();
       }
    }   
    
    @POST
    public void addBook(@FormParam("titre") String titre,
               @FormParam("auteur") String author,
               @FormParam("categorie") String category,
               @FormParam("isbn") int isbn,
               @FormParam("quantite") int quantity) {
        Modele instance = Modele.getInstance();        
        if(instance.searchBook(isbn) == null) {
            instance.addBook(author, category, isbn, quantity, titre);
        };
    }


    @POST
    @Path("updateBook")
    public void updateBook(@FormParam("titre") String titre,
               @FormParam("auteur") String author,
               @FormParam("categorie") String category,
               @FormParam("isbn") int isbn,
               @FormParam("quantite") int quantity) {
        Modele instance = Modele.getInstance();
        instance.updateBook(author, category, isbn, quantity, titre);
    }
    
    @POST
    @Path("deleteBook")
    public void deleteCustomer(@FormParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        instance.deleteBook(isbn);
    }


}
