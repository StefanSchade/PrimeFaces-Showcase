package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import de.stefanschade.primefacesshowcase.frontend.beans.entities.ProductTemplate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
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

    @Inject
    private FieldTable fieldTable;

    @Inject
    private TemplateTable templateTable;

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
        templateTable.retrieveLast();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsNextButtonClick() {
        fieldTable.retrieveNext();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsBackButtonClick() {
        fieldTable.retrieveLast();
        fieldTable.unSelectFieldDetails();
    }

    public void fieldsDetailsButtonClicked(ConfigurableField field) {
        fieldTable.selectFieldDetails(field);
    }

}
