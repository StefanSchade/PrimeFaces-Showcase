package de.stefanschade.backend.service.impl;

import de.stefanschade.backend.domain.ProductCategoryEntity;
import de.stefanschade.backend.dto.ProductCategoryDto;
import de.stefanschade.backend.repositories.ProductCategoryRepository;
import de.stefanschade.backend.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryServiceImpl  implements ProductCategoryService  {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity entityToBeStored = new ProductCategoryEntity();
        if (productCategoryRepository.findById(productCategoryDto.getId()) != null)
            throw new RuntimeException("Record already exists");
        BeanUtils.copyProperties(productCategoryDto, entityToBeStored); // will throw an error, if non-null annotation is violated
        ProductCategoryEntity enitityThatWasStored = productCategoryRepository.save(entityToBeStored);
        ProductCategoryDto returnValue = new ProductCategoryDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        return returnValue;

    }

    @Override
    public ProductCategoryDto getProductCategoryById(String id) {
        return null;
    }
}
