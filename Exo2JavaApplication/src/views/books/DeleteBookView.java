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
public class DeleteBookView extends JPanel implements View{
    private Modele modele;
    
    public DeleteBookView(Modele modele){
        this.modele = modele;
        
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Supprimer livre");
        
        JLabel ISBNL = new JLabel("ISBN ");
        JTextField ISBNT = new JTextField();
        
        JButton validateButton = new JButton("Supprimer");
        
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
        c.gridx = 2;
        c.gridy = 1;
        this.add(validateButton, c);
    
    }  
    
    @Override
    public void update() {
    }
    
}
