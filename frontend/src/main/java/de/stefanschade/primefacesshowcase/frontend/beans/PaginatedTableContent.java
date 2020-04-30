package de.stefanschade.primefacesshowcase.frontend.beans;

import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Getter
@Setter
@ViewScoped
public class PaginatedTableContent implements Serializable {

    @Inject
    private ProductTemplateService service;

    private List<ProductTemplate> productTemplateList;

    int page = 0;

    final int size = 20;

    int firstEntry = 1;

    int lastEntry = size;

    @PostConstruct
    public void init() {
        productTemplateList = service.retrieveTemplates(size, page);
    }

    public void nextButtonClick() {
        productTemplateList = service.retrieveTemplates(size, ++page);
        updateFields();
    }

    public void backButtonClick() {
        productTemplateList = service.retrieveTemplates(size, --page);
        updateFields();
    }

    private void updateFields() {
        firstEntry = page * size + 1;
        lastEntry = firstEntry + productTemplateList.size();
        for (ProductTemplate temp : productTemplateList)
            temp.setFieldCount(temp.getFields().size());
    }
}
