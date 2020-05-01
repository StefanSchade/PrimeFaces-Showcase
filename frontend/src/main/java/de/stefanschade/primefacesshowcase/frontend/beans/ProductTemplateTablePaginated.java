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
import java.util.List;

@Slf4j
@Named
@Getter
@Setter
@ViewScoped
public class ProductTemplateTablePaginated implements Serializable {

    @Inject
    private ProductTemplateService service;

    private List<ProductTemplate> productTemplateList;

    int page = 0;

    final int size = 20;

    int firstEntry = 1;

    int lastEntry = size;

    boolean showBackButton = true;

    boolean showNextButton = true;

    @PostConstruct
    public void init() {
        updateFields();
    }

    public void nextButtonClick() {
        page++;
        updateFields();
    }

    public void backButtonClick() {
        page--;
        updateFields();
    }

    private void updateFields() {
        productTemplateList = service.retrieveTemplates(size, page);

        for (ProductTemplate template : productTemplateList)
            template.setFieldCount(template.getFields().size());

        boolean nextPageHasContent = service.retrieveTemplates(size, page + 1).size() > 0;
        if (page < 1) {
            setShowBackButton(false);
        } else {
            setShowBackButton(true);
        }
        if (productTemplateList.size() < size | !nextPageHasContent) {
            setShowNextButton(false);
        } else {
            setShowNextButton(true);
        }

        firstEntry = page * size + 1;
        lastEntry = firstEntry + productTemplateList.size();

        log.info("ProductTemplate updated: "
                + " page " + page
                + " size " + size
                + " firstEntry " + firstEntry
                + " lastEntry " + lastEntry
                + " showNextButton " + showNextButton
                + " showBackButton " + showBackButton);
    }
}
