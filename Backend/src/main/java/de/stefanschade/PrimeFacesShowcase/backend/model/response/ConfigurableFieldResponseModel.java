package de.stefanschade.PrimeFacesShowcase.backend.model.response;

import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableFieldResponseModel {

    private String fieldName;
    private FieldType fieldType;
}
