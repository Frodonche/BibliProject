/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

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
    
}
