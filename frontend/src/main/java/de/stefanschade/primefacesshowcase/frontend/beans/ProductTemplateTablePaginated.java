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

    private List<ProductTemplate> currentProductTemplateList;

    private List<ProductTemplate> nextProductTemplateList;

    int page = 0;

    final int size = 20;

    int firstEntry = 1;

    int lastEntry = size;

    boolean showBackButton = true;

    boolean showNextButton = true;

    @PostConstruct
    public void init() {
        currentProductTemplateList = service.retrieveTemplates(size, 0);
        nextProductTemplateList = service.retrieveTemplates(size,  1);
        updateFields();
    }

    public void nextButtonClick() {
        currentProductTemplateList = nextProductTemplateList;
        nextProductTemplateList = service.retrieveTemplates(size, ++page);
        updateFields();
    }

    public void backButtonClick() {
        nextProductTemplateList = currentProductTemplateList;
        currentProductTemplateList = service.retrieveTemplates(size, --page);
        updateFields();
    }

    private void updateFields() {
        for (ProductTemplate template : currentProductTemplateList)
            template.setFieldCount(template.getFields().size());

        boolean nextPageHasContent = nextProductTemplateList.size() > 0;
        if (page < 1) {
            setShowBackButton(false);
        } else {
            setShowBackButton(true);
        }
        if (currentProductTemplateList.size() < size | !nextPageHasContent) {
            setShowNextButton(false);
        } else {
            setShowNextButton(true);
        }

        firstEntry = page * size + 1;
        lastEntry = firstEntry + currentProductTemplateList.size();

        log.info("ProductTemplate updated: "
                + " page " + page
                + " size " + size
                + " firstEntry " + firstEntry
                + " lastEntry " + lastEntry
                + " showNextButton " + showNextButton
                + " showBackButton " + showBackButton);
    }
}
