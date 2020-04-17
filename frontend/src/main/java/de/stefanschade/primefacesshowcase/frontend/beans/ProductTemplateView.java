package de.stefanschade.primefacesshowcase.frontend.beans;

import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.extern.java.Log;
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

    private List<String> productTemplateNames = new ArrayList<>();

    private List<ConfigurableField> configurableFields = new ArrayList<>();

    private int changeCounter = 0;

    @Inject
    private ProductTemplateService service;

    @PostConstruct
    public void init() {
        productTemplates = service.retrieveTemplates();
    }

    public void changeSelectedTemplate() {
        changeCounter++;
        log.info("template changed");
    }

}
