package de.stefanschade.primefacesshowcase.debugclient.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurableField {

    private String fieldname;
    private FieldType fieldType;
}
