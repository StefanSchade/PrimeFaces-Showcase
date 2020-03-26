package de.stefanschade.PrimeFacesShowcase.backend.controller;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.PrimeFacesShowcase.backend.model.response.ProductTemplateResponseModel;
import de.stefanschade.PrimeFacesShowcase.backend.service.ConfigurationFieldService;
import de.stefanschade.PrimeFacesShowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("product-template")
public class ProductTemplateController {

    @Autowired
    ProductTemplateService productTemplateService;

    @Autowired
    ConfigurationFieldService configurationFieldService;

    @GetMapping
    public List<ProductTemplateResponseModel> getAllProductTemplates() {
        List<ProductTemplateDto>  productTemplateDtoList = productTemplateService.getAll();
        List<ProductTemplateResponseModel> returnValue = new ArrayList<>(productTemplateDtoList.size());
        Iterator<ProductTemplateDto> productTemplateDtoIterator = productTemplateDtoList.iterator();
        while (productTemplateDtoIterator.hasNext()) {
            //todo finish implementation
        }
        return returnValue;
    }

    // todo implement endpoint for one specific Template

}
