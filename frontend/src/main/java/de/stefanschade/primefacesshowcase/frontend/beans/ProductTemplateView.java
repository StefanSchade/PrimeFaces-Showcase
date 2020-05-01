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
import java.util.Date;
import java.util.List;

@Slf4j
@Named("productTemplateView")
@ViewScoped
@Getter
@Setter
public class ProductTemplateView implements Serializable {

    private List<ConfigurableField> configurableFieldList = new ArrayList<>();

    @PostConstruct
    public void init() {
    }

}
