/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.customer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modele.Modele;
import views.View;

/**
 *
 * @author guigu
 */
public class SearchCustomerView extends JPanel implements View{
    private Modele modele;
    
    public SearchCustomerView(Modele modele){
        this.modele = modele;
        
        GridLayout grille = new GridLayout(2,1);
        this.setLayout(grille);
        
        JPanel panelHaut = new JPanel();
        JPanel panelBas = new JPanel();
        
        GridBagLayout layout = new GridBagLayout();
        panelHaut.setLayout(layout);
        
        
        
        JLabel title = new JLabel("Rechercher adherent");
        
        JLabel numCustomerL = new JLabel("N° Adherent ");
        JTextField numCustomerT = new JTextField();
        
        JLabel lastNameCustomerL = new JLabel("Nom ");
        JTextField lastNameCustomerT = new JTextField();
        
        JLabel surNameCustomerL = new JLabel("Prenom ");
        JTextField surNameCustomerT = new JTextField();
        
        JLabel addressCustomerL = new JLabel("Adresse ");
        JTextField addressCustomerT = new JTextField();
        
        JButton validateButton = new JButton("Rechercher");
        
        JTextArea results = new JTextArea(12, 50);
        results.setEditable(false);
        results.setAutoscrolls(true);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        panelHaut.add(title, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        panelHaut.add(numCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panelHaut.add(numCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        panelHaut.add(lastNameCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        panelHaut.add(lastNameCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        panelHaut.add(surNameCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        panelHaut.add(surNameCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        panelHaut.add(validateButton, c);
        
        
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        panelBas.add(results, c);
        
        this.add(panelHaut);
        this.add(panelBas);
        
        this.setVisible(true);
    
    }  
    
    @Override
    public void update() {
    }
    
}
