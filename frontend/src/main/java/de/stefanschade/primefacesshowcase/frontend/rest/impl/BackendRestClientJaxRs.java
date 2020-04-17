package de.stefanschade.primefacesshowcase.frontend.rest.impl;

import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.rest.BackendRestClient;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@ApplicationScoped
public class BackendRestClientJaxRs implements BackendRestClient  {

    public List<ProductTemplate> productTemplates() {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8082/producttemplate");

        Response response = target.request().get();

        List<ProductTemplate> productTemplates = response.readEntity(List.class);
        response.close();

        log.info("backend returned {} product templates", productTemplates.size());

        return productTemplates;
    }
}
