package de.stefanschade.PrimeFacesShowcase.backend.service;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import org.springframework.stereotype.Service;

@Service
    public interface ConfigurableFieldService {

    ConfigurableFieldDto createConfigurationField(ConfigurableFieldDto configurationField);
    ConfigurableFieldDto getConfigurationFieldById(String id);
}
