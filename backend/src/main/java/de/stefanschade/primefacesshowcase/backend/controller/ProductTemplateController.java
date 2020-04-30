package de.stefanschade.primefacesshowcase.backend.controller;

import de.stefanschade.primefacesshowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.model.response.ConfigurableFieldResponseModel;
import de.stefanschade.primefacesshowcase.backend.model.response.ProductTemplateResponseModel;
import de.stefanschade.primefacesshowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
public class ProductTemplateController {

    @Autowired
    ProductTemplateService productTemplateService;

    @GetMapping("/producttemplatelist")
    public List<ProductTemplateResponseModel> getAllProductTemplates() {
        List<ProductTemplateDto> productTemplateDtoList = productTemplateService.getAll();
        return mapProductTemplateDtoListToResponseList(productTemplateDtoList);
    }

    // see https://www.baeldung.com/rest-api-pagination-in-spring
    // http://localhost:8082/producttemplatelistpaginated?size=10&page=100&sort=templatename
    @GetMapping("/producttemplatelistpaginated")
    public List<ProductTemplateResponseModel> getAllProductTemplatesPaginated(
            @PageableDefault(size = 5) Pageable pageable) {
        List<ProductTemplateDto> productTemplateDtoList = productTemplateService.findAll(pageable);
        return mapProductTemplateDtoListToResponseList(productTemplateDtoList);

    }

    private List<ProductTemplateResponseModel> mapProductTemplateDtoListToResponseList(List<ProductTemplateDto> productTemplateDtoList) {
        Iterator<ProductTemplateDto> productTemplateDtoIterator = productTemplateDtoList.iterator();
        List<ProductTemplateResponseModel> returnValue = new ArrayList<>(productTemplateDtoList.size());
        while (productTemplateDtoIterator.hasNext()) {
            ProductTemplateResponseModel productTemplateResponseModel = new ProductTemplateResponseModel();
            ProductTemplateDto productTemplateDto = productTemplateDtoIterator.next();
            BeanUtils.copyProperties(productTemplateDto, productTemplateResponseModel);
            Iterator<ConfigurableFieldDto> configurableFieldDtoIterator = productTemplateDto.getFieldsdto().iterator();
            List<ConfigurableFieldResponseModel> configurableFieldResponseModelList = new ArrayList<>();
            while (configurableFieldDtoIterator.hasNext()) {
                ConfigurableFieldDto currentFieldDto = configurableFieldDtoIterator.next();
                ConfigurableFieldResponseModel currentFieldResponseModel = new ConfigurableFieldResponseModel();
                BeanUtils.copyProperties(currentFieldDto, currentFieldResponseModel);
                configurableFieldResponseModelList.add(currentFieldResponseModel);
            }
            productTemplateResponseModel.setFields(configurableFieldResponseModelList);
            returnValue.add(productTemplateResponseModel);
        }
        return returnValue;
    }

}