package de.stefanschade.primefacesshowcase.frontend.beans;

import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.Setter;
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
@Setter
public class ProductTemplateView implements Serializable {

    private List<ProductTemplate> productTemplateList = new ArrayList<>();
    private List<ConfigurableField> configurableFieldList = new ArrayList<>();

    private List<String> productTemplateNames = new ArrayList<>();

    private List<ConfigurableField> configurableFields = new ArrayList<>();

    private int selectCounter = 0;

    private ProductTemplate selectedTemplate;

    @Inject
    private ProductTemplateService service;

    @PostConstruct
    public void init() {
        productTemplateList = service.retrieveTemplates();
        ProductTemplate template;
        for (int i = 0; i < productTemplateList.size(); i++) {
            template = productTemplateList.get(i);
            template.setFieldCount(template.getFields().size());
        }
    }

    public void templateButtonClicked(ProductTemplate template) {
        this.selectedTemplate = template;
        this.configurableFieldList = template.getFields();
        this.selectCounter++;
    }
}
