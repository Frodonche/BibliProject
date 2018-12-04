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
public class Book {
    private int isbn;
    private String titre;
    private String auteur;
    private String categorie;
    private int quantite;
    
    public Book(int isbn, String titre, String auteur, String categorie, int quantite){
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.quantite = quantite;
    }
    
    public int getIsbn(){ return this.isbn; }
    public void setIsbn(int isbn){ this.isbn = isbn; }
    
    public String getTitre(){ return this.titre; }
    public void setTitre(String titre){ this.titre = titre; }
    
    public String getAuteur(){ return this.auteur; }
    public void setAuteur(String auteur){ this.auteur = auteur; }
    
    public String getCategorie(){ return this.categorie; }
    public void setCategorie(String categorie){ this.categorie = categorie; }
    
    public int getQuantite(){ return this.quantite; }
    public void setQuantite(int quantite){ this.quantite = quantite; }
    
    public String toXML(){
        String toReturn = "<book>";
        toReturn += "<isbn>"+isbn+"</isbn>";
        toReturn += "<titre>"+titre+"</titre>";
        toReturn += "<auteur>"+auteur+"</auteur>";
        toReturn += "<categorie>"+categorie+"</categorie>";
        toReturn += "<quantite>"+quantite+"</quantite>";
        toReturn += "</book>";
        
        return toReturn;
    }
    
    public String toXMLWithHeader(){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        toReturn += toXML();
        
        return toReturn;
    }
    
    public String toJSON(){
        String toReturn = "{";
        toReturn += "\"isbn\":"+"\""+isbn+"\",";
        toReturn += "\"titre\":"+"\""+titre+"\",";
        toReturn += "\"auteur\":"+"\""+auteur+"\",";
        toReturn += "\"categorie\":"+"\""+categorie+"\",";
        toReturn += "\"quantite\":"+"\""+quantite+"\"";
        
        toReturn += "}";
        
        return toReturn;
    }
}
