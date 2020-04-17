package de.stefanschade.primefacesshowcase.backend.service.impl;

import de.stefanschade.primefacesshowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.primefacesshowcase.backend.repositories.ProductTemplateRepository;
import de.stefanschade.primefacesshowcase.backend.service.ProductTemplateService;
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

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

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
        List<ProductTemplateDto> returnProductTemplateList = new ArrayList<>();
        Iterator<ProductTemplateEntity> originalProductTemplateList = productTemplateRepository.findAll().iterator();
        while (originalProductTemplateList.hasNext()) {
            ProductTemplateDto currentProductTemplateDTO = new ProductTemplateDto();
            ProductTemplateEntity currentProductTemplateEntity = originalProductTemplateList.next();
            BeanUtils.copyProperties(currentProductTemplateEntity, currentProductTemplateDTO);
            List<ConfigurableFieldEntity> fieldsForCurrentTemplateEntity
                    = configurableFieldRepository.findByTemplate(currentProductTemplateEntity);
            Iterator<ConfigurableFieldEntity> fieldEntityIterator = fieldsForCurrentTemplateEntity.iterator();
            log.info("processing template " + currentProductTemplateDTO.getTemplatename());
            while (fieldEntityIterator.hasNext()) {
                ConfigurableFieldEntity configurableFieldEntity = fieldEntityIterator.next();
                log.info("processing field " + configurableFieldEntity.getFieldname());
                ConfigurableFieldDto configurableFieldDto = new ConfigurableFieldDto();
                BeanUtils.copyProperties(configurableFieldEntity, configurableFieldDto);
                currentProductTemplateDTO.getFieldsdto().add(configurableFieldDto);
            }
            returnProductTemplateList.add(currentProductTemplateDTO);
        }
        return returnProductTemplateList;
    }

}