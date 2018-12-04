/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import modele.Modele;
import panes.CustomerTabbedPane;

/**
 *
 * @author guigu
 */
public class CustomerFrame extends JFrame{
    
    public CustomerFrame(Modele modele){
        super("Gestion adherents");
        
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CustomerTabbedPane customer = new CustomerTabbedPane(modele);
        
        this.add(customer);
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        this.setLocation((int)(defaultScreen.getDefaultConfiguration().getBounds().getMaxX()/2)-600, (int)(defaultScreen.getDefaultConfiguration().getBounds().getMaxY()/4));
        
        this.setVisible(true);
    }
}
