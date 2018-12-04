/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import views.customer.DeleteCustomerView;
import views.customer.ModifyCustomerView;

import javax.swing.JTabbedPane;
import modele.Modele;
import views.books.AddBookView;
import views.books.BorrowBookView;
import views.books.DeleteBookView;
import views.books.ModifyBookView;
import views.books.SearchBookView;

/**
 *
 * @author guigu
 */
public class BooksTabbedPane extends JTabbedPane{
    private Modele modele;
    
    public BooksTabbedPane(Modele modele){
        this.modele = modele;
        
        AddBookView addBook = new AddBookView(modele);
        SearchBookView searchBook = new SearchBookView(modele);
        DeleteBookView deleteBook = new DeleteBookView(modele);
        ModifyBookView modifyBook = new ModifyBookView(modele);
        BorrowBookView borrowBook = new BorrowBookView(modele);
        
        this.addTab("Ajouter livre", addBook);
        this.addTab("Rechercher livre", searchBook);
        this.addTab("Supprimer livre", deleteBook);
        this.addTab("Modifier livre", modifyBook);
        this.addTab("Eprunter livre", borrowBook);
        
        this.setVisible(true);
    }  
   
    
}
