package de.stefanschade.backend.model.response;

import de.stefanschade.backend.dto.FieldType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ConfigurationFieldResponseModel {

    private Long id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
