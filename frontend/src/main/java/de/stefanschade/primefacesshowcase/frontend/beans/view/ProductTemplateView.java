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
    private ConfigurableFieldTablePaginated configurableFieldTablePaginated;

    @Inject
    private ProductTemplateTablePaginated productTemplateTablePaginated;

    public void templateDetailsButtonClicked(ProductTemplate template) {
        productTemplateTablePaginated.selectTemplate(template);
        configurableFieldTablePaginated.selectTemplate(template.getFields());
    }

    public void templateNextButtonClick() {
        productTemplateTablePaginated.unSelectTemplate();
        productTemplateTablePaginated.retrieveNext();
        configurableFieldTablePaginated.unSelectFieldDetails();
    }

    public void templateBackButtonClick() {
        productTemplateTablePaginated.unSelectTemplate();
        productTemplateTablePaginated.retrieveLast();
        configurableFieldTablePaginated.unSelectFieldDetails();
    }

    public void fieldsNextButtonClick() {
        configurableFieldTablePaginated.retrieveNext();
        configurableFieldTablePaginated.unSelectFieldDetails();
    }

    public void fieldsBackButtonClick() {
        configurableFieldTablePaginated.retrieveLast();
        configurableFieldTablePaginated.unSelectFieldDetails();
    }

    public void fieldsDetailsButtonClicked(ConfigurableField field) {
        configurableFieldTablePaginated.selectFieldDetails(field);
    }

}
