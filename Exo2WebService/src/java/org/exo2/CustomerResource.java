/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

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
@Path("customer")
public class CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }
    
    @POST
    @Path("login")
    public void login(@FormParam("numero") int numero,
            @FormParam("nom") String nom) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c!=null) {
            c.login();
        }
    } 

      
    @POST
    @Path("logout")
    public void logout(@FormParam("numero") int numero,
            @FormParam("nom") String nom) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c!=null) {
            c.logout();
        }
    }   
    
    @POST
    public String inscription(@FormParam("numero") int numero,
               @FormParam("nom") String nom,
               @FormParam("prenom") String prenom,
               @FormParam("adresse") String adresse) {
        
        Modele instance = Modele.getInstance();
        if(instance.searchCustomer(numero) == null) {
            Customer c = new Customer(numero, nom, prenom, adresse);
            instance.addCustomer(c);
        };
        
        Customer cu = instance.searchCustomer(numero);
        return cu.getPrenom();
    }
    
       
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("searchCustomerXML")
    public String searchCustomerXML(@QueryParam("numero") int numero) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c == null) {
            String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
            return toReturn;
        } else {
            return c.toXMLWithHeader();
        }        
    }

    @GET
    @Path("searchCustomerJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchCustomerJSON(@QueryParam("numero") int numero) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c == null) {
            String toReturn = "{"+numero+"}";
            return toReturn;
        } else {
            return c.toJSON();
        }        
    }
     
    @PUT
    public void updateCustomer(@FormParam("numero") int numero,
               @QueryParam("nom") String nom,
               @QueryParam("prenom") String prenom,
               @QueryParam("adresse") String adresse) {
        Modele instance = Modele.getInstance();
        instance.updateCustomer(new Customer(numero, nom, prenom, adresse));
    }
    
    @POST
    @Path("deleteCustomer")
    public void deleteCustomer(@FormParam("numero") int numero) {
        Modele instance = Modele.getInstance();
        instance.deleteCustomer(numero);
    }
    
    @POST
    @Path("borrow")
    public void borrow(@FormParam("numero") int numero,
            @FormParam("nom") String nom,
            @FormParam("isbn") int isbn) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c!=null && c.getLogged() && (instance.countBorrowsByCustomer(numero)< 4)) {
            instance.addBorrow(isbn, numero);
        }
    }  
}
