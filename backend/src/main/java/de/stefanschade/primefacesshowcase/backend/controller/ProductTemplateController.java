package de.stefanschade.primefacesshowcase.backend.controller;

import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.mapper.ProductTemplateMapper;
import de.stefanschade.primefacesshowcase.backend.model.response.ProductTemplateResponseModel;
import de.stefanschade.primefacesshowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ProductTemplateController {

    @Autowired ProductTemplateService productTemplateService;

    @Autowired ProductTemplateMapper productTemplateMapper;

    @GetMapping("/producttemplatelist")
    public List<ProductTemplateResponseModel> getAllProductTemplates() {
        return mapProductTemplateDtoListToResponseList(productTemplateService.getAll());
    }

    // see https://www.baeldung.com/rest-api-pagination-in-spring
    // http://localhost:8082/producttemplatelistpaginated?size=10&page=100&sort=templatename

    private List<ProductTemplateResponseModel> mapProductTemplateDtoListToResponseList(List<ProductTemplateDto> productTemplateDtoList) {
        return productTemplateDtoList
                .stream()
                .map(productTemplateMapper::productTemplateDtoToProductTemplateResponseModel)
                .collect(Collectors.toList());
    }

    @GetMapping("/producttemplatelistpaginated")
    public List<ProductTemplateResponseModel> getAllProductTemplatesPaginated(@PageableDefault(
            size = 5) Pageable pageable) {
        return mapProductTemplateDtoListToResponseList(productTemplateService.findAll(pageable));

    }
}