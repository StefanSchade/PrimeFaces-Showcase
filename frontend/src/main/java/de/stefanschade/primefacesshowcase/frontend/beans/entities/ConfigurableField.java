package de.stefanschade.primefacesshowcase.frontend.beans.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableField {
    private String fieldname;
    private FieldType fieldType;
}
