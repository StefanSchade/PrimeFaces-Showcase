package de.stefanschade.PrimeFacesShowcase.backend.service;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductCategoryService  {

    ProductTemplateDto createProductCategory(ProductTemplateDto productTemplateDto);

    ProductTemplateDto getProductCategoryById(String id);


}
