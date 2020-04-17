package de.stefanschade.primefacesshowcase.frontend.service;

import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.rest.BackendRestClient;
import de.stefanschade.primefacesshowcase.frontend.rest.impl.BackendRestClientJaxRs;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Slf4j
@Getter
@Named
@ApplicationScoped
public class ProductTemplateService {

    @Inject
    private BackendRestClient backendRestClient;

    public List<ProductTemplate> retrieveTemplates() {
        log.info("Simple Logging facade works now");

        return backendRestClient.productTemplates();
    }

}
