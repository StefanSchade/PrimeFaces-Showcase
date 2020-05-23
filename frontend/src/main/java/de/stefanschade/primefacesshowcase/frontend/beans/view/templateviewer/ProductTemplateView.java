package de.stefanschade.primefacesshowcase.frontend.beans.view.templateviewer;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import de.stefanschade.primefacesshowcase.frontend.beans.session.SessionInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Slf4j
@Named("productTemplateView")
@ViewScoped
@Getter
@Setter
public class ProductTemplateView implements Serializable {

    @Inject private SessionInformation sessionInformation;

    @Inject private FieldTable fieldTable;

    @Inject private TemplateTable templateTable;

    @PreDestroy public void writeResults() {
        ProductTemplate productTemplate = templateTable.getTemplateSelected();
        if (productTemplate == null) sessionInformation.setResultTemplateBrowser("No Selection");
        else sessionInformation.setResultTemplateBrowser("Selected " + productTemplate.getTemplatename());
    }

    public void templateDetailsButtonClicked(ProductTemplate template) {
        templateTable.selectTemplate(template);
        fieldTable.selectTemplate(template.getFields());
    }

    public void templateNextButtonClick() {
        templateTable.unSelectTemplate();
        templateTable.retrieveNext();
        fieldTable.unSelectFieldDetails();
    }

    public void templateBackButtonClick() {
        templateTable.unSelectTemplate();
        templateTable.retrievePrevious();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsNextButtonClick() {
        fieldTable.retrieveNext();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsBackButtonClick() {
        fieldTable.retrievePrevious();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsDetailsButtonClicked(ConfigurableField field) {
        fieldTable.selectFieldDetails(field);
    }
}