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
public class toast {
    
    public static void main(String[] args){
        Book b = new Book(45, "toto", "laura", "poisson", 1);
        System.out.println(b.toJSON());
    }
}
