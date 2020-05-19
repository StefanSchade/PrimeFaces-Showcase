package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Named
@ViewScoped
public class TemplateTable implements Serializable {

    private final int PAGESIZE = 20;

    @Getter private int currentPage;
    @Getter private List<ProductTemplate> productTemplateListCurrentPage;
    @Getter private boolean backButtonVisible = true;
    @Getter private boolean nextButtonVisible = true;
    @Getter private ProductTemplate templateSelected = null;
    @Getter private boolean templateIsSelected = false;

    @Inject private ProductTemplateService productTemplateService;
    private List<ProductTemplate> productTemplateListNextPage;

    @PostConstruct
    public void init() {
        this.currentPage = 0;
        this.productTemplateListCurrentPage = productTemplateService.retrieveTemplates(PAGESIZE, 0);
        this.productTemplateListNextPage = productTemplateService.retrieveTemplates(PAGESIZE, 1);
        this.updateVisibilityOfPaginationButtons();
    }

    protected void retrieveNext() {
        this.productTemplateListCurrentPage = productTemplateListNextPage;
        this.productTemplateListNextPage = productTemplateService.retrieveTemplates(PAGESIZE, ++currentPage + 1);
        this.updateVisibilityOfPaginationButtons();
    }

    protected void retrievePrevious() {
        this.productTemplateListNextPage = productTemplateListCurrentPage;
        this.productTemplateListCurrentPage = productTemplateService.retrieveTemplates(PAGESIZE, --currentPage);
        this.updateVisibilityOfPaginationButtons();
    }

    private void updateVisibilityOfPaginationButtons() {
        this.backButtonVisible = currentPage >= 1;
        this.nextButtonVisible = productTemplateListCurrentPage.size() == PAGESIZE & productTemplateListNextPage.size() > 0;
    }

    protected void selectTemplate(ProductTemplate productTemplate) {
        this.templateIsSelected = true;
        this.templateSelected = productTemplate;
    }

    protected void unSelectTemplate() {
        this.templateIsSelected = false;
        this.templateSelected = null;
    }

    public boolean checkTemplateForSelection(ProductTemplate productTemplate) {
        if (!this.templateIsSelected) return false;
        return productTemplate.equals(this.templateSelected);
    }

    public String rowClasses() {
        if (!this.templateIsSelected) return "odd, even";
        StringBuilder returnValue = new StringBuilder();
        Iterator<ProductTemplate> iterator = this.productTemplateListCurrentPage.iterator();
        boolean oddEvenFlip = true;
        while (iterator.hasNext()) {
            if (iterator.next().equals(this.templateSelected)) returnValue.append("highlight");
            else returnValue.append(oddEvenFlip ? "odd" : "even");
            if (iterator.hasNext()) returnValue.append(", ");
            oddEvenFlip = !oddEvenFlip;
        }
        return returnValue.toString();
    }
}