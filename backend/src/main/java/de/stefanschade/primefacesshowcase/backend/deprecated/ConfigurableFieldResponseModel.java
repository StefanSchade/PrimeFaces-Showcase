package de.stefanschade.primefacesshowcase.backend.deprecated;

import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Deprecated
@Slf4j
@Data
public class ConfigurableFieldResponseModel {

    private Long id;
    private String fieldName;
    private Integer fieldLength;
    private FieldType fieldType;

}
