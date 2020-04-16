package de.stefanschade.primefacesshowcase.frontend.beans;

import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Named("productTemplateView")
@ViewScoped
@Getter
public class ProductTemplateView implements Serializable {

    private List<ProductTemplate> productTemplates = new ArrayList<>();

    @Inject
    private ProductTemplateService service;

    @PostConstruct
    public void init() {
        productTemplates = service.retrieveTemplates();
    }

}
