package de.stefanschade.primefacesshowcase.frontend.rest;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@ApplicationScoped
public class BackendRestClient {

    private final String BASE_URI = "http://localhost:";

    private final String PORT = "8082";

    public List<ProductTemplate> productTemplates() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI + PORT + "/producttemplatelist");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<ProductTemplate> productTemplates = builder.get(new GenericType<List<ProductTemplate>>() {
        });
        System.out.println(productTemplates);
        client.close();
        return productTemplates;
    }

    public List<ProductTemplate> productTemplates(int size, int page) {
        System.out.println("checking " + BASE_URI + PORT + "/producttemplatelistpaginated");
        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target(BASE_URI + PORT)
                .path("/producttemplatelistpaginated")
                .queryParam("page", Integer.toString(page))
                .queryParam("size", Integer.toString(size));
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<ProductTemplate> productTemplates = builder.get(new GenericType<List<ProductTemplate>>() {
        });
        client.close();
        return productTemplates;
    }
}