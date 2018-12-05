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
public class Borrow {
    private int isbn;
    private int numCustomer;
    
    public Borrow(int isbn, int numCustomer){
        this.isbn = isbn;
        this.numCustomer = numCustomer;
    }
    
    public int getIsbn(){ return this.isbn; }
    public void setIsbn(int isbn){ this.isbn = isbn; }
    
    public int getNumCustomer(){ return this.numCustomer; }
    public void setNumCustomer(int numCustomer){ this.numCustomer = numCustomer; }
    
    public String toXML(){
        String toReturn = "<borrow>";
        toReturn += "<isbn>"+isbn+"</isbn>";
        toReturn += "<numCustomer>"+numCustomer+"</numCustomer>";
        toReturn +="</borrow>";
        
        return toReturn;
    }
    
    public String toXMLWithHeader(){
        String toReturn = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        toReturn += toXML();
        
        return toReturn;
    }
    
    public String toJSON(){
        String toReturn = "{";
        toReturn += "\"isbn\":"+isbn+",";
        toReturn += "\"numCustomer\":"+numCustomer;
        toReturn += "}";
        
        return toReturn;
    }
}
