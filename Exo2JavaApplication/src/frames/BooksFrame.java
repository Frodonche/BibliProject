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
import panes.BooksTabbedPane;
import panes.CustomerTabbedPane;

/**
 *
 * @author guigu
 */
public class BooksFrame extends JFrame{
    
    public BooksFrame(Modele modele){
        super("Gestion livres");
        
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BooksTabbedPane books = new BooksTabbedPane(modele);
        
        this.add(books);
        
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        this.setLocation((int)defaultScreen.getDefaultConfiguration().getBounds().getMaxX()/2, (int)defaultScreen.getDefaultConfiguration().getBounds().getMaxY()/4);
        this.setVisible(true);
    }
}
