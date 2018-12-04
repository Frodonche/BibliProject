/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exo2;

/**
 *
 * @author guillaume
 */
public class Customer {
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;    
    
    public Customer(int numero, String nom, String prenom, String adresse){
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    
    public int getNumero(){ return this.numero; }
    public void setNumero(int numero){ this.numero = numero; }
    
    public String getNom(){ return this.nom; }
    public void setNom(String nom){ this.nom = nom; }
    
    public String getPrenom(){ return this.prenom; }
    public void setPrenom(String prenom){ this.prenom = prenom; }
    
    public String adresse(){ return this.adresse; }
    public void setAdresse(String adresse){ this.adresse = adresse; }
    
    public String toXML(){
        String toReturn = "<customer>";
        toReturn += "<numero>"+numero+"</numero>";
        toReturn += "<nom>"+nom+"</nom>";
        toReturn += "<prenom>"+prenom+"</prenom>";
        toReturn += "<adresse>"+adresse+"</adresse>";
        toReturn += "</customer>";
        
        return toReturn;
    }
    
    public String toXMLWithHeader(){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        toReturn += toXML();
        
        return toReturn;
    }
}
