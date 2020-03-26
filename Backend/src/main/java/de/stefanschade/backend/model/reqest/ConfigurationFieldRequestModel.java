package de.stefanschade.backend.model.reqest;

import de.stefanschade.backend.dto.FieldType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ConfigurationFieldRequestModel {

    private String id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
