package de.stefanschade.PrimeFacesShowcase.backend.service;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTemplateService {

    ProductTemplateDto createProductCategory(ProductTemplateDto productTemplateDto);

    ProductTemplateDto getProductCategoryById(String id);

    List<ProductTemplateDto> getAll();


}
