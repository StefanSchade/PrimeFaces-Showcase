package de.stefanschade.PrimeFacesShowcase.frontend;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Slf4j
@Named
@ViewScoped
@Getter
public class ProductTemplateView implements Serializable {

    private List<ProductTemplate> productTemplates;

    @Inject
    private ProductTemplateService service;

    @PostConstruct
    public void init() {
        productTemplates = service.retrieveTemplates();
    }

    //    public void setService(ProductTemplateService service) {

}
