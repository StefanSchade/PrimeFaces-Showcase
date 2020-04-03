package de.stefanschade.PrimeFacesShowcase.frontend;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import javax.json.JsonArray;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Named
@Getter
public class ProductTemplateService {

    public List<ProductTemplate> retrieveTemplates() {

        List<ProductTemplate> returnValue = new ArrayList<>();
        log.info("Testing");
        returnValue.add(new ProductTemplate("testtemplate", null));

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8082/producttemplate");
        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        for (JsonValue currentelement : response) {
            System.out.println("XXXX " + currentelement);
            returnValue.add(((JsonString) currentelement).getString());
        }
        return returnValue;
    }

}