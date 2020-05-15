package de.stefanschade.primefacesshowcase.backend.service.impl;

import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.mapper.ProductTemplateMapper;
import de.stefanschade.primefacesshowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.primefacesshowcase.backend.repositories.ProductTemplateRepository;
import de.stefanschade.primefacesshowcase.backend.repositories.ProductTemplateRepositoryPagination;
import de.stefanschade.primefacesshowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ProductTemplateServiceImpl implements ProductTemplateService {

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Autowired
    ProductTemplateRepositoryPagination productTemplateRepositoryPagination;

    @Autowired
    ProductTemplateMapper productTemplateMapper;

    @Override
    public ProductTemplateDto createProductTemplate(ProductTemplateDto productTemplateDto) {
        ProductTemplateEntity entityToBeStored = new ProductTemplateEntity();
        BeanUtils.copyProperties(productTemplateDto, entityToBeStored); // will throw an error, if non-null annotation is violated
        ProductTemplateEntity enitityThatWasStored = productTemplateRepository.save(entityToBeStored);
        ProductTemplateDto returnValue = new ProductTemplateDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        log.info("logging works here");
        return returnValue;
    }

    @Override
    public ProductTemplateDto getProductCategoryById(String id) {
        return null;
    }

    @Override
    public List<ProductTemplateDto> getAll() {
        return mapProductTemplateEntityIterableToDtoList(productTemplateRepository.findAll());
    }

    private List<ProductTemplateDto> mapProductTemplateEntityIterableToDtoList(Iterable<ProductTemplateEntity> productTemplateEntityIterable) {
        return StreamSupport.stream(productTemplateEntityIterable.spliterator(), false)
                .map(productTemplateMapper::productTemplateEntityToProductTemplateDto)
                .collect(Collectors.toList());
    }

    // https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
    @Transactional(readOnly = true)
    @Override
    public List<ProductTemplateDto> findAll(Pageable pageable) {
        Page<ProductTemplateEntity> page = productTemplateRepositoryPagination.findAll(pageable);
        List<ProductTemplateEntity> productTemplateEntityList = page.getContent();
        log.info("Page count " + page.getTotalPages() + " Element count " + page.getTotalElements());
        return mapProductTemplateEntityIterableToDtoList(productTemplateEntityList);
    }
}

