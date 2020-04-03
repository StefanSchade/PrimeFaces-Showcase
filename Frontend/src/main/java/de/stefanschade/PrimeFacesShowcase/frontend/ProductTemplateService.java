package de.stefanschade.PrimeFacesShowcase.frontend;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Named
@Getter
public class ProductTemplateService {

    public List<ProductTemplate> retrieveTemplates() {

        List<ProductTemplate> returnValue = new ArrayList<>();
        System.out.println("Testing");
        returnValue.add(new ProductTemplate("testtemplate", null));

//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8082/producttemplate");
//        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
//        for (JsonValue currentelement : response) {
//            System.out.println("XXXX " + currentelement);
//            returnValue.add(((JsonString) currentelement).getString());
//        }
        return returnValue;
    }

}