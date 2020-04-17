package de.stefanschade.primefacesshowcase.frontend.rest.impl;

import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.rest.BackendRestClient;
import java.util.List;

public class BackendRestClientResteasy implements BackendRestClient {

    final String PATH = "http://localhost:8082/producttemplate";

    @Override
    public List<ProductTemplate> productTemplates() {

//        org.eclipse.microprofile.rest.client
//        ServiceClient service = org.eclipse.microprofile.rest.client.RestClientBuilder.newBuilder()
//                .baseUrl("http://localhost:8081/")
//                .build(ServiceClient.class);
//        String s = service.test();



        return null;
    }
}
