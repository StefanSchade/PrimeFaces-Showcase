package de.stefanschade.PrimeFacesShowcase.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class ConfigurationFieldDto {

    private String id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
