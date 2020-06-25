package de.stefanschade.primefacesshowcase.backend.model.response;

import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableFieldResponseModel {

    private String fieldname;

    private FieldType fieldType;
}
