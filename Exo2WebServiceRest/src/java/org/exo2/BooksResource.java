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
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
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
    @Path("isAvailableXML")
    @Produces(MediaType.APPLICATION_XML)
    public String isAvailableXML(@QueryParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Book b = instance.searchBook(isbn);
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        if(b != null && b.getQuantite() > 0){
            return toReturn+"true";
        } else {
            return toReturn+"false";
        }
    }

    @GET
    @Path("isAvailableJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String isAvailableJSON(@QueryParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Book b = instance.searchBook(isbn);
        String toReturn = "";
        if(b != null && b.getQuantite() > 0){
            return toReturn+"{'available' : true}";
        } else {
            return toReturn+"{'available' : false}";
        }
    }
    
    
    @GET
    @Path("listXML")
    @Produces(MediaType.APPLICATION_XML)
    public String listXML() {
        Modele instance = Modele.getInstance();
        return instance.getBooksXML();
    }    
    
    @GET
    @Path("listJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String listJSON() {
        Modele instance = Modele.getInstance();
        return instance.getBooksJSON();
    }    
    
    
    @GET
    @Path("searchByTitleXML")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByTitleXML(@QueryParam("title") String title) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookTitre(title);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("searchByTitleJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByTitleJSON(@QueryParam("title") String title) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookTitre(title);
        return instance.getBooksJSON(list);
    }   

    
    
    @GET
    @Path("searchByAuthorXML")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByAuthorXML(@QueryParam("author") String author) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookAuteur(author);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("searchByAuthorJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByAuthorJSON(@QueryParam("author") String author) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookAuteur(author);
        return instance.getBooksJSON(list);
    }   

    @GET
    @Path("searchByCategoryXML")
    @Produces(MediaType.APPLICATION_XML)
    public String searchByCategoryXML(@QueryParam("category") String categorie) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookCategorie(categorie);
        return instance.getBooksXML(list);
    }   
    
    @GET
    @Path("searchByCategoryJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchByCategoryJSON(@QueryParam("category") String categorie) {
        Modele instance = Modele.getInstance();
        ArrayList<Book> list = instance.searchBookCategorie(categorie);
        return instance.getBooksJSON(list);
    }   
    
    @GET
    @Path("searchByIsbnXML")
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
    @Path("searchByIsbnJSON")
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

}
