/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.customer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modele.Modele;
import views.View;

/**
 *
 * @author guigu
 */
public class DeleteCustomerView extends JPanel implements View{
    private Modele modele;
    
    public DeleteCustomerView(Modele modele){
        this.modele = modele;
        
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Supprimer adherent");
        
        JLabel numCustomerL = new JLabel("N° Adherent ");
        JTextField numCustomerT = new JTextField();
        
        JButton validateButton = new JButton("Supprimer");
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(title, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(numCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(numCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        this.add(validateButton, c);
    
    }  
    
    @Override
    public void update() {
    }
    
}
