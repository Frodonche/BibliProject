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
import javax.swing.JTabbedPane;
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
public class ModifyCustomerView extends JPanel implements View{
    private Modele modele;
    
    public ModifyCustomerView(Modele modele){
        this.modele = modele;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        JLabel title = new JLabel("Modifier adherent");
        
        JLabel numCustomerL = new JLabel("N° Adherent ");
        JTextField numCustomerT = new JTextField();
        
        JLabel lastNameCustomerL = new JLabel("Nom ");
        JTextField lastNameCustomerT = new JTextField();
        
        JLabel surNameCustomerL = new JLabel("Prenom ");
        JTextField surNameCustomerT = new JTextField();
        
        JLabel addressCustomerL = new JLabel("Adresse ");
        JTextField addressCustomerT = new JTextField();
        
        JButton validateButton = new JButton("Valider modification");
        
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
        c.gridx = 0;
        c.gridy = 2;
        this.add(lastNameCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        this.add(lastNameCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        this.add(surNameCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        this.add(surNameCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        this.add(addressCustomerL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        this.add(addressCustomerT, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
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
                params.add("nom",lastNameCustomerT.getText());
                params.add("prenom", surNameCustomerT.getText());
                params.add("adresse", addressCustomerT.getText());

                service.path("customer/updateCustomer")
                        .queryParams(params)
                        .type(MediaType.APPLICATION_FORM_URLENCODED)
                        .post();
            }
        
        });
        
        this.setVisible(true);
    }  
    
    @Override
    public void update() {
    }
    
}
