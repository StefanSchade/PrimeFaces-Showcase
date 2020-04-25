package de.stefanschade.primefacesshowcase.debugclient.rest;

import de.stefanschade.primefacesshowcase.debugclient.datamodel.HelloWorld;
import de.stefanschade.primefacesshowcase.debugclient.datamodel.ProductTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class HelloWorldClient {


    private final String BASE_URI =
            "http://localhost:";
    private final String PORT = "8082";

    public void JerseyHelloWorld() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI + PORT + "/helloworld");
        Invocation.Builder builder = target.request();
        HelloWorld result = builder.get(HelloWorld.class);
        System.out.println(result);
        client.close();
    }

    // http://www.adam-bien.com/roller/abien/entry/jax_rs_retrieving_a_list
    public void JerseyHelloWorldList() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI + PORT + "/helloworldlist");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<HelloWorld> resultList = builder.get(new GenericType<List<HelloWorld>>() {
        });
        System.out.println(resultList);
        client.close();
    }

    public void JerseyClientForShowcase() {
        System.out.println("checking "+ BASE_URI + PORT + "/producttemplatelist");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI + PORT + "/producttemplatelist");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<ProductTemplate> productTemplates =
                builder.get(new GenericType<List<ProductTemplate>>() {
                });
        System.out.println(productTemplates);

        ProductTemplate template = productTemplates.get(0);

        System.out.println("name: " + template.getTemplatename());
        System.out.println("fields: " + template.getFields());

        client.close();
    }
}
