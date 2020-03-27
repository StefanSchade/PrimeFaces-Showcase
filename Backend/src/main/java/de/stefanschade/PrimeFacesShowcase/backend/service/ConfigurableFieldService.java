package de.stefanschade.PrimeFacesShowcase.backend.service;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import org.springframework.stereotype.Service;

@Service
    public interface ConfigurableFieldService {

    ConfigurableFieldDto createConfigurableFiled(ConfigurableFieldDto configurationField);
    ConfigurableFieldDto getConfigurableFieldById(Long id);
//    List<ConfigurableFieldDto> getConfigurableFieldsByTemplateName(String templateName);

}
