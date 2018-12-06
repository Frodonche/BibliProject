/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2javaapplication;

import frames.BooksFrame;
import frames.CustomerFrame;
import modele.Modele;
import panes.CustomerTabbedPane;
import views.customer.AddCustomerView;

/**
 *
 * @author guigu
 */
public class Exo2JavaApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modele modele = new Modele();
        CustomerFrame customer = new CustomerFrame(modele);
        //BooksFrame books = new BooksFrame(modele);
        
    }
    
}
