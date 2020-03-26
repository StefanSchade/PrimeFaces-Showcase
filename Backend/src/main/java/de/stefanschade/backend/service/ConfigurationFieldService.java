package de.stefanschade.backend.service;

import de.stefanschade.backend.dto.ConfigurationFieldDto;
import org.springframework.stereotype.Service;

@Service
public interface ConfigurationFieldService {
    ConfigurationFieldDto createConfigurationField(ConfigurationFieldDto configurationField);
    ConfigurationFieldDto getConfigurationFieldById(String id);
}
