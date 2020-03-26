package de.stefanschade.backend.service.impl;

import de.stefanschade.backend.domain.ConfigurationFieldEntity;
import de.stefanschade.backend.dto.ConfigurationFieldDto;
import de.stefanschade.backend.repositories.ConfigurationFieldRepository;
import de.stefanschade.backend.service.ConfigurationFieldService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigurationFieldServiceImpl implements ConfigurationFieldService {

    @Autowired
    ConfigurationFieldRepository configurationFieldRepository;

    @Override
    public ConfigurationFieldDto createConfigurationField(ConfigurationFieldDto configurationField) {
        ConfigurationFieldEntity entityToBeStored = new ConfigurationFieldEntity();
        if (configurationFieldRepository.findById(configurationField.getId()) != null)
            throw new RuntimeException("Record already exists");
        BeanUtils.copyProperties(configurationField, entityToBeStored); // will throw an error, if non-null annotation is violated
        ConfigurationFieldEntity enitityThatWasStored = configurationFieldRepository.save(entityToBeStored);
        ConfigurationFieldDto returnValue = new ConfigurationFieldDto();
        BeanUtils.copyProperties(enitityThatWasStored, returnValue);
        return returnValue;
    }

    @Override
    public ConfigurationFieldDto getConfigurationFieldById(String id) {
        ConfigurationFieldEntity retrievedEntry = configurationFieldRepository.findById(id);
        if(retrievedEntry == null) throw new IllegalArgumentException("id " + id);
        ConfigurationFieldDto returnValue = new ConfigurationFieldDto();
        BeanUtils.copyProperties(retrievedEntry, returnValue);
        return returnValue;
    }
}
