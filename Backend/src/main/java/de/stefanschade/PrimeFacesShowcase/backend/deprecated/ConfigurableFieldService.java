package de.stefanschade.PrimeFacesShowcase.backend.deprecated;

import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurableFieldDto;
import org.springframework.stereotype.Service;
@Deprecated
@Service
    public interface ConfigurableFieldService {

    ConfigurableFieldDto createConfigurableFiled(ConfigurableFieldDto configurationField);
    ConfigurableFieldDto getConfigurableFieldById(Long id);
//    List<ConfigurableFieldDto> getConfigurableFieldsByTemplateName(String templateName);

}
