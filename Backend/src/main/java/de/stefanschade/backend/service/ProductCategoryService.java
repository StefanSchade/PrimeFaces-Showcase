package de.stefanschade.backend.service;

import de.stefanschade.backend.dto.ProductCategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductCategoryService  {

    ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);

    ProductCategoryDto getProductCategoryById(String id);


}
