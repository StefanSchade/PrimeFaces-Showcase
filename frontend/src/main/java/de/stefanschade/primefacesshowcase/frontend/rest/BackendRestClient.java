package de.stefanschade.primefacesshowcase.frontend.rest;

import de.stefanschade.primefacesshowcase.frontend.beans.ConfigurableField;
import de.stefanschade.primefacesshowcase.frontend.beans.FieldType;
import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ApplicationScoped
public class BackendRestClient {


    private final String BASE_URI =
            "http://localhost:";
    private final String PORT = "8082";

    public List<ProductTemplate> productTemplates1() {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(BASE_URI + PORT + "/producttemplatelistpaginated");

        Response response = target.request().get();

        List<ProductTemplate> productTemplates = response.readEntity(List.class);
        response.close();

        log.info("backend returned {} product templates", productTemplates.size());

        return productTemplates;

    }

    public List<ProductTemplate> productTemplates() {

//        Client client = javax.ws.rs.client.ClientBuilder.newClient();
//
//        WebTarget  webTarget = client.target(BASE_URI + PORT);
//        WebTarget resource = webTarget.path("producttemplate");
//        javax.ws.rs.client.Invocation.Builder builder=resource.
//                request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
//        Invocation invocation=builder.buildGet();
//        GenericType responseType=new GenericType<List<ProductTemplate>>() { };
//        List<ProductTemplate> productTemplates = (List<ProductTemplate>) invocation.invoke(responseType);
//        log.info("backend returned {} product templates", productTemplates.size());

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI + PORT + "/producttemplatelist");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<ProductTemplate> productTemplates =
                builder.get(new GenericType<List<ProductTemplate>>() {
                });
        System.out.println(productTemplates);
        client.close();

//        List<ConfigurableField> configurableFieldList = new ArrayList<>();
//
//        configurableFieldList.add(new ConfigurableField("field01",FieldType.INTEGER));
//        configurableFieldList.add(new ConfigurableField("field02",FieldType.INTEGER));
//        configurableFieldList.add(new ConfigurableField("field03",FieldType.INTEGER));
//        configurableFieldList.add(new ConfigurableField("field04",FieldType.INTEGER));

//        productTemplates.add(0,new ProductTemplate("MyTepmplate Name",configurableFieldList));

        return productTemplates;
    }
}
