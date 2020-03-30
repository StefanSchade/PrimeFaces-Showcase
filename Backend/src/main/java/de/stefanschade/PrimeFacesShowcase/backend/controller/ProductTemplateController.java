package de.stefanschade.PrimeFacesShowcase.backend.controller;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.PrimeFacesShowcase.backend.model.response.ConfigurableFieldResponseModel;
import de.stefanschade.PrimeFacesShowcase.backend.model.response.ProductTemplateResponseModel;
import de.stefanschade.PrimeFacesShowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("producttemplate")
public class ProductTemplateController {

    @Autowired
    ProductTemplateService productTemplateService;

    @GetMapping
    public List<ProductTemplateResponseModel> getAllProductTemplates() {
        List<ProductTemplateDto>  productTemplateDtoList = productTemplateService.getAll();
        List<ProductTemplateResponseModel> returnValue = new ArrayList<>(productTemplateDtoList.size());
        Iterator<ProductTemplateDto> productTemplateDtoIterator = productTemplateDtoList.iterator();
        while (productTemplateDtoIterator.hasNext()) {
            ProductTemplateResponseModel productTemplateResponseModel = new ProductTemplateResponseModel();
            ProductTemplateDto productTemplateDto = productTemplateDtoIterator.next();
            BeanUtils.copyProperties(productTemplateDto, productTemplateResponseModel);
            Iterator<ConfigurableFieldDto> configurableFieldDtoIterator = productTemplateDto.getFieldsdto().iterator();
            List<ConfigurableFieldResponseModel> configurableFieldResponseModelList = new ArrayList<>();
            while (configurableFieldDtoIterator.hasNext()) {
                ConfigurableFieldDto currentFieldDto = configurableFieldDtoIterator.next();
                ConfigurableFieldResponseModel currentFieldResponseModel = new ConfigurableFieldResponseModel();
                BeanUtils.copyProperties(currentFieldDto,currentFieldResponseModel);
                configurableFieldResponseModelList.add(currentFieldResponseModel);
            }
            productTemplateResponseModel.setFieldsmodel(configurableFieldResponseModelList);
            returnValue.add(productTemplateResponseModel);
        }
        return returnValue;
    }

}
