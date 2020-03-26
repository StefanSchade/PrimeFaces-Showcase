package de.stefanschade.PrimeFacesShowcase.backend.service;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurationFieldDto;
import org.springframework.stereotype.Service;

@Service
    public interface ConfigurationFieldService {

    ConfigurationFieldDto createConfigurationField(ConfigurationFieldDto configurationField);
    ConfigurationFieldDto getConfigurationFieldById(String id);
}
