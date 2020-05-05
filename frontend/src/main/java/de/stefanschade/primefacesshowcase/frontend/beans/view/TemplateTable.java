package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.service.ProductTemplateService;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@ViewScoped
public class TemplateTable implements Serializable {

    @Inject
    private ProductTemplateService service;

    private ProductTemplate templateSelected = null;
    private boolean templateIsSelected = false;

    private List<ProductTemplate> currentProductTemplateList;
    private List<ProductTemplate> nextProductTemplateList;

    int size = 20;
    int page = 0;

    boolean showBackButton = true;
    boolean showNextButton = true;;

    @PostConstruct
    public void init() {
        currentProductTemplateList = service.retrieveTemplates(size, 0);
        nextProductTemplateList = service.retrieveTemplates(size, 1);
        update();
    }

    private void update() {
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

        int firstEntry = page * size + 1;
        int lastEntry = firstEntry + currentProductTemplateList.size();

        log.info("Template Table updated: "
                + " page " +    page
                + " size " +    size
                + " first " +   firstEntry
                + " last " +    lastEntry
                + " next " +    showNextButton
                + " back " +    showBackButton
        );
    }

    public void selectTemplate(ProductTemplate template) {
        this.templateIsSelected = true;
        this.templateSelected = template;
    }

    public void unSelectTemplate() {
        this.templateIsSelected = false;
        this.templateSelected = null;
    }

    public void retrieveNext() {
        this.currentProductTemplateList = nextProductTemplateList;
        this.nextProductTemplateList = service.retrieveTemplates(size, ++page + 1);
        update();
    }

    public void retrieveLast() {
        this.nextProductTemplateList = currentProductTemplateList;
        this.currentProductTemplateList = service.retrieveTemplates(size, --page);
        update();
    }

    public boolean checkTemplateForSelection(ProductTemplate template) {
        if (!this.templateIsSelected) return false;
        return template.equals(this.templateSelected);
    }

    public String rowClasses() {
        if (!this.templateIsSelected) return "odd, even";

        StringBuilder returnValue = new StringBuilder();
        Iterator<ProductTemplate> iterator = this.currentProductTemplateList.iterator();
        boolean oddEvenFlip = false;

        while (iterator.hasNext()) {
            if (iterator.next().equals(this.templateSelected)) {
                returnValue.append("highlight");
            } else {
                returnValue.append(oddEvenFlip ? "even" : "odd");
            }
            oddEvenFlip = !oddEvenFlip;
            if (iterator.hasNext()) {
                returnValue.append(", ");
            }
        }

        log.info("template rowClasses " + returnValue.toString());
        return returnValue.toString();
    }
}