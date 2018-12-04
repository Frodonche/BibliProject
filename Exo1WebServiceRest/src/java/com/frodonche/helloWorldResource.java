/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frodonche;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author guigu
 */
@Path("helloWorldService")
public class helloWorldResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of helloWorldResource
     */

    @GET 
    @Produces("text/plain") 
    @Path("helloWorldSimple")
    public String HelloWorldSimple() {
        return "Hello World !";
    } 
    
    @GET 
    @Produces("text/plain") 
    @Path("helloWorldSimpleArg")
    public String HelloWorldSimpleParam(@QueryParam("nom") String nom) {
        return "Hello "+nom+" !";
    } 
    
    @POST 
    @Produces("text/plain")
    public String HelloWorldParams(@FormParam("prenom") String value) {
        return "Hello " + value + " !";
    }  
   
}
