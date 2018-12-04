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
public class ModifyBookView extends JPanel implements View{
    private Modele modele;
    
    public ModifyBookView(Modele modele){
         this.modele = modele;
        
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Modifier livre");
        
        JLabel ISBNL = new JLabel("ISBN ");
        JTextField ISBNT = new JTextField();
        
        JLabel titreL = new JLabel("Titre ");
        JTextField titreT = new JTextField();
        
        JLabel auteurL = new JLabel("Auteur ");
        JTextField auteurT = new JTextField();
        
        JLabel categorieL = new JLabel("Categorie ");
        JTextField categorieT = new JTextField();
        
        JButton validateButton = new JButton("Valider modification");
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(title, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(ISBNL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(ISBNT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        this.add(titreL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        this.add(titreT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        this.add(auteurL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        this.add(auteurT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        this.add(categorieL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        this.add(categorieT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        this.add(validateButton, c);
        
        this.setVisible(true);
    
    }  
    
    @Override
    public void update() {
    }
    
}
