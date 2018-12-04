/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import views.customer.DeleteCustomerView;
import views.customer.ModifyCustomerView;
import views.customer.SearchCustomerView;
import views.customer.AddCustomerView;
import views.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import modele.Modele;

/**
 *
 * @author guigu
 */
public class CustomerTabbedPane extends JTabbedPane{
    private Modele modele;
    
    public CustomerTabbedPane(Modele modele){
        this.modele = modele;
        
        AddCustomerView addCustomer = new AddCustomerView(modele);
        SearchCustomerView searchCustomer = new SearchCustomerView(modele);
        DeleteCustomerView deleteCustomer = new DeleteCustomerView(modele);
        ModifyCustomerView modifyCustomer = new ModifyCustomerView(modele);
        
        this.addTab("Inscrire adherent", addCustomer);
        this.addTab("Rechercher adherent", searchCustomer);
        this.addTab("Supprimer adherent", deleteCustomer);
        this.addTab("Modifier adherent", modifyCustomer);
        
        this.setVisible(true);
    }  
   
    
}
