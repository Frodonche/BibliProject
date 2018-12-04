/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.books;

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
public class SearchBookView extends JPanel implements View{
    private Modele modele;
    
    public SearchBookView(Modele modele){
        this.modele = modele;
        
        GridLayout grille = new GridLayout(2,1);
        this.setLayout(grille);
        
        JPanel panelHaut = new JPanel();
        JPanel panelBas = new JPanel();
        
        GridBagLayout layout = new GridBagLayout();
        panelHaut.setLayout(layout);
        
        
        
        JLabel title = new JLabel("Rechercher livre");
        
        JLabel ISBNL = new JLabel("ISBN ");
        JTextField ISBNT = new JTextField();
        
        JLabel titreL = new JLabel("Titre ");
        JTextField titreT = new JTextField();
        
        JLabel auteurL = new JLabel("Auteur ");
        JTextField auteurT = new JTextField();
        
        JLabel categorieL = new JLabel("Categorie ");
        JTextField categorieT = new JTextField();
        
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
        panelHaut.add(ISBNL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        panelHaut.add(ISBNT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        panelHaut.add(titreL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        panelHaut.add(titreT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        panelHaut.add(auteurL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        panelHaut.add(auteurT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        panelHaut.add(categorieL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        panelHaut.add(categorieT, c);
        
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
