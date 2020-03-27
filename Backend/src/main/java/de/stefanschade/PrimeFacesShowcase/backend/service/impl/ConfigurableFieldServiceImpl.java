package de.stefanschade.PrimeFacesShowcase.backend.service.impl;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.PrimeFacesShowcase.backend.service.ConfigurableFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ConfigurableFieldServiceImpl implements ConfigurableFieldService {

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Override
    public ConfigurableFieldDto createConfigurationField(ConfigurableFieldDto configurationField) {
        ConfigurableFieldEntity entityToBeStored = new ConfigurableFieldEntity();
        if (configurableFieldRepository.findById(configurationField.getId()) != null)
            throw new RuntimeException("Record already exists");
        BeanUtils.copyProperties(configurationField, entityToBeStored); // will throw an error, if non-null annotation is violated
        ConfigurableFieldEntity enitityThatWasStored = configurableFieldRepository.save(entityToBeStored);
        ConfigurableFieldDto returnValue = new ConfigurableFieldDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        return returnValue;
    }

    @Override
    public ConfigurableFieldDto getConfigurationFieldById(String id) {
        ConfigurableFieldEntity retrievedEntry = configurableFieldRepository.findById(id);
        if(retrievedEntry == null) throw new IllegalArgumentException("id " + id);
        ConfigurableFieldDto returnValue = new ConfigurableFieldDto();
        BeanUtils.copyProperties(retrievedEntry, returnValue);
        return returnValue;
    }
}
