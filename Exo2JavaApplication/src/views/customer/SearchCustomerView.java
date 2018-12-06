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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
        
        JButton validateButtonXML = new JButton("RechercherXML");
        JButton validateButtonJSON = new JButton("RechercherJSON");
        
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
        c.gridx = 2;
        c.gridy = 5;
        panelHaut.add(validateButtonJSON, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 6;
        panelBas.add(validateButtonXML, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        panelBas.add(results, c);
        
        this.add(panelHaut);
        this.add(panelBas);
        
        validateButtonXML.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ClientConfig config = new DefaultClientConfig();
                Client client = Client.create(config);
                WebResource service = client.resource(
                    UriBuilder.fromUri("http://localhost:8080/Exo2WebService/webresources").build()
                );
                
                MultivaluedMap params = new MultivaluedMapImpl();
                params.add("numero",numCustomerT.getText());

                String XML = service.path("customer/XML/searchCustomer")
                        .queryParams(params)
                        .type(MediaType.APPLICATION_FORM_URLENCODED)
                        .get(String.class);
                
                System.out.println(XML);
                results.setText(XML);
                results.setVisible(true);
                
            }
        
        });

        validateButtonJSON.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                ClientConfig config = new DefaultClientConfig();
                Client client = Client.create(config);
                WebResource service = client.resource(
                    UriBuilder.fromUri("http://localhost:8080/Exo2WebService/webresources").build()
                );
                
                MultivaluedMap params = new MultivaluedMapImpl();
                params.add("numero",numCustomerT.getText());

                String JSON = service.path("customer/JSON/searchCustomer")
                        .queryParams(params)
                        .type(MediaType.APPLICATION_FORM_URLENCODED)
                        .get(String.class);
                
                System.out.println(JSON);
                results.setText(JSON);
                results.setVisible(true);
            }
        
        });

        this.setVisible(true);
    
    }  
    
    @Override
    public void update() {
    }
    
}
