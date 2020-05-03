package de.stefanschade.primefacesshowcase.frontend.service;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.rest.BackendRestClient;
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
        return backendRestClient.productTemplates();
    }

    public List<ProductTemplate> retrieveTemplates(int size, int page) {
        log.info("retrieve page " + page);
        return backendRestClient.productTemplates(size,page);
    }
}
