package de.stefanschade.PrimeFacesShowcase.backend.service.impl;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ProductTemplateRepository;
import de.stefanschade.PrimeFacesShowcase.backend.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryServiceImpl  implements ProductCategoryService  {

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Override
    public ProductTemplateDto createProductCategory(ProductTemplateDto productTemplateDto) {
        ProductTemplateEntity entityToBeStored = new ProductTemplateEntity();
        if (productTemplateRepository.findById(productTemplateDto.getId()) != null)
            throw new RuntimeException("Record already exists");
        BeanUtils.copyProperties(productTemplateDto, entityToBeStored); // will throw an error, if non-null annotation is violated
        ProductTemplateEntity enitityThatWasStored = productTemplateRepository.save(entityToBeStored);
        ProductTemplateDto returnValue = new ProductTemplateDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        return returnValue;

    }

    @Override
    public ProductTemplateDto getProductCategoryById(String id) {
        return null;
    }
}
