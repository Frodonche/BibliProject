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
@Path("inscription")
public class InscriptionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InscriptionResource
     */
    public InscriptionResource() {
    }


    /**
     * POST method for updating or creating an instance of InscriptionResource
     * @param content representation for the resource
     */
    @POST
    public void putXml(@QueryParam("numero") int numero,
               @QueryParam("nom") String nom,
               @QueryParam("prenom") String prenom,
               @QueryParam("adresse") String adresse) {
    }
}
