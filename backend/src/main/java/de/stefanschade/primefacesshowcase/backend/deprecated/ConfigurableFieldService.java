package de.stefanschade.primefacesshowcase.backend.deprecated;

import de.stefanschade.primefacesshowcase.backend.dto.ConfigurableFieldDto;
import org.springframework.stereotype.Service;
@Deprecated
@Service
    public interface ConfigurableFieldService {

    ConfigurableFieldDto createConfigurableFiled(ConfigurableFieldDto configurationField);
    ConfigurableFieldDto getConfigurableFieldById(Long id);
//    List<ConfigurableFieldDto> getConfigurableFieldsByTemplateName(String templateName);

}
