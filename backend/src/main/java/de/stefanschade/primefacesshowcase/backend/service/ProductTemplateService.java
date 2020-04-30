package de.stefanschade.primefacesshowcase.backend.service;

import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTemplateService {

    ProductTemplateDto createProductTemplate(ProductTemplateDto productTemplateDto);

    ProductTemplateDto getProductCategoryById(String id);

    List<ProductTemplateDto> getAll();

    List<ProductTemplateDto> findAll(Pageable pageable);
}
