package exo1javaapplication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.util.Scanner;
import javax.ws.rs.core.MultivaluedMap;

import javax.ws.rs.core.UriBuilder;

public class HelloWorldClient {
    private WebResource service;
    
    public HelloWorldClient(String prenom)
    {
        this.initializeService();
        this.callhelloworldService(prenom);
    }
    
    private void initializeService() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(
        UriBuilder.fromUri("http://localhost:8080/Exo1WebServiceRest/webresources").build());
    }
    
    private void callhelloworldService(String prenom) {
        MultivaluedMap params = new MultivaluedMapImpl(); 
        params.add("nom", prenom); 
        
        String result = service
            .path("/helloWorldService/helloWorldSimpleArg")
            .queryParams(params)
            .accept("text/plain")  
            .get(new GenericType<String>(){});
        System.out.println(result);
    }
        
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez votre prenom");
        String prenom = scan.next();
        new HelloWorldClient(prenom);
    }
}