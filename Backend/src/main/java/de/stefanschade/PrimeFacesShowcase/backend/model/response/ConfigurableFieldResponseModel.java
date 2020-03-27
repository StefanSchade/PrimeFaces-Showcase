package de.stefanschade.PrimeFacesShowcase.backend.model.response;

import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ConfigurableFieldResponseModel {

    private Long id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
