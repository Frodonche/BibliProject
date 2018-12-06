/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.customer;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
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
    
        
            validateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ClientConfig config = new DefaultClientConfig();
                Client client = Client.create(config);
                WebResource service = client.resource(
                    UriBuilder.fromUri("http://localhost:8080/Exo2WebService/webresources").build()
                );
                
                MultivaluedMap params = new MultivaluedMapImpl();
                params.add("numero",numCustomerT.getText());

                service.path("customer/deleteCustomer")
                        .queryParams(params)
                        .type(MediaType.APPLICATION_FORM_URLENCODED)
                        .post();
                
            }
        
        });
    }  
    
    @Override
    public void update() {
    }
    
}
