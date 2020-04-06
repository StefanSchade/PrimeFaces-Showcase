package de.stefanschade.primefacesshowcase;

import de.stefanschade.primefacesshowcase.frontend.ProductTemplate;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
@Named
@ApplicationScoped
public class ProductTemplateService {

    public List<ProductTemplate> retrieveTemplates() {
        log.info("Simple Logging facade works now");

        List<ProductTemplate> returnValue = new ArrayList<>();

        ProductTemplate testTemplate = new ProductTemplate("testtemplate", Collections.emptyList());

        returnValue.add(testTemplate);

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
