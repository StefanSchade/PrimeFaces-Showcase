package de.stefanschade.PrimeFacesShowcase.backend.model.reqest;

import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ConfigurableFieldRequestModel {

    private String id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}