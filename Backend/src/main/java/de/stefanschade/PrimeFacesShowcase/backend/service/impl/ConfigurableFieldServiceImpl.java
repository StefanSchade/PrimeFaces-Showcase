package de.stefanschade.PrimeFacesShowcase.backend.service.impl;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.PrimeFacesShowcase.backend.service.ConfigurableFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ConfigurableFieldServiceImpl implements ConfigurableFieldService {

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Override
    public ConfigurableFieldDto createConfigurableFiled(ConfigurableFieldDto configurableFieldDto) {
        ConfigurableFieldEntity entityToBeStored = new ConfigurableFieldEntity();

        //todo: Is this needed at all? Uniqueness should be tested by the jpa annotations anyway

//        if (configurableFieldRepository.findBytemplatenameAndFieldName(configurableFieldDto.getTemplateName(),
//                configurableFieldDto.getFieldName()).size()!=0)
//            throw new RuntimeException("ConfigurableFiled (" + configurableFieldDto.getTemplateName() +
//                    ", "+configurableFieldDto.getFieldName() + ") already exists!" );

        BeanUtils.copyProperties(configurableFieldDto, entityToBeStored); // will throw an error, if constraints are violated
        ConfigurableFieldEntity enitityThatWasStored = configurableFieldRepository.save(entityToBeStored);
        ConfigurableFieldDto returnValue = new ConfigurableFieldDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        return returnValue;
    }

    @Override
    public ConfigurableFieldDto getConfigurableFieldById(Long id) {
        Optional<ConfigurableFieldEntity> retrievedEntry = configurableFieldRepository.findById(id);
        if (retrievedEntry == null) throw new RuntimeException("Record (ID:" + id + ") not found");
        ConfigurableFieldDto returnValue = new ConfigurableFieldDto();
        BeanUtils.copyProperties(retrievedEntry, returnValue);
        return returnValue;
    }

//    @Override
//    public List<ConfigurableFieldDto> getConfigurableFieldsByTemplateName(String templateName) {
//        List<ConfigurableFieldEntity> configurableFieldEntityList = configurableFieldRepository.findBytemplatename(templateName);
//        int numberOfResults = configurableFieldEntityList.size();
//        List<ConfigurableFieldDto> returnValue = new ArrayList<>(numberOfResults);
//        Iterator<ConfigurableFieldEntity> resultIterator = configurableFieldEntityList.iterator();
//        while (resultIterator.hasNext()) {
//            ConfigurableFieldDto resultEntryAsDto = new ConfigurableFieldDto();
//            ConfigurableFieldEntity resultEntryAsEntity = resultIterator.next();
//            BeanUtils.copyProperties(resultEntryAsEntity, resultEntryAsDto);
//        }
//        return returnValue;
//    }
}
