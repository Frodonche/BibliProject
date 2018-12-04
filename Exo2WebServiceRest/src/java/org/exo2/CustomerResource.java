/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

import javax.annotation.Resource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
     * Creates a new instance of InscriptionResource
     */
    public CustomerResource() {
    }


    /**
     * POST method for updating or creating an instance of InscriptionResource
     * @param content representation for the resource
     */
    @POST
    @Path("inscription")
    public void inscription(@QueryParam("numero") int numero,
               @QueryParam("nom") String nom,
               @QueryParam("prenom") String prenom,
               @QueryParam("adresse") String adresse) {
        Modele instance = Modele.getInstance();
        if(instance.searchCustomer(numero) == null) {
            instance.addCustomer(new Customer(numero, nom, prenom, adresse));
        };
    }
    
    @GET
    @Path("searchCustomerXML")
    @Produces(MediaType.APPLICATION_XML)
    public String searchCustomerXML(@QueryParam("numero") int numero) {
        Modele instance = Modele.getInstance();
        Customer c = instance.searchCustomer(numero);
        if(c == null) {
            String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?> ERROR: Not found";
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
            String toReturn = "{}";
            return toReturn;
        } else {
            return c.toJSON();
        }        
    }
    
    @PUT
    @Path("deleteCustomer")
    public void deleteCustomer(@QueryParam("numero") int numero) {
        Modele instance = Modele.getInstance();
        instance.deleteCustomer(numero);
    }
    
    @PUT
    @Path("updateCustomer")
    public void updateCustomer(@QueryParam("numero") int numero,
               @QueryParam("nom") String nom,
               @QueryParam("prenom") String prenom,
               @QueryParam("adresse") String adresse) {
        Modele instance = Modele.getInstance();
        instance.updateCustomer(new Customer(numero, nom, prenom, adresse));
    }



}
