package de.stefanschade.PrimeFacesShowcase.backend.service.impl;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ProductTemplateRepository;
import de.stefanschade.PrimeFacesShowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class ProductTemplateServiceImpl implements ProductTemplateService {

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Override
    public ProductTemplateDto createProductTemplate(ProductTemplateDto productTemplateDto) {
        ProductTemplateEntity entityToBeStored = new ProductTemplateEntity();
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

    @Override
    public List<ProductTemplateDto> getAll() {
        List<ProductTemplateDto> returnProductTemplateList = new ArrayList<>();
        Iterator<ProductTemplateEntity> originalProductTemplateList = productTemplateRepository.findAll().iterator();
        while (originalProductTemplateList.hasNext()) {
            ProductTemplateDto currentProductTemplateDTO = new ProductTemplateDto();
            ProductTemplateEntity currentProductTemplateEntity = originalProductTemplateList.next();
            BeanUtils.copyProperties(currentProductTemplateEntity, currentProductTemplateDTO);
            List<ConfigurableFieldEntity> fieldsForCurrentTemplateEntity = new ArrayList<>();
            Iterator<ConfigurableFieldEntity> fieldEntityIterator = fieldsForCurrentTemplateEntity.iterator();
            while (fieldEntityIterator.hasNext()) {
                ConfigurableFieldEntity configurableFieldEntity = fieldEntityIterator.next();
                ConfigurableFieldDto configurableFieldDto = new ConfigurableFieldDto();
                BeanUtils.copyProperties(configurableFieldEntity, configurableFieldDto);
                currentProductTemplateDTO.getFieldsdto().add(configurableFieldDto);
            }
            returnProductTemplateList.add(currentProductTemplateDTO);
        }
        return returnProductTemplateList;
    }

}
