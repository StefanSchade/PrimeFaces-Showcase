package de.stefanschade.PrimeFacesShowcase.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableFieldDto {

    private String templateName;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
