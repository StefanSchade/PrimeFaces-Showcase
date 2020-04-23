package de.stefanschade.primefacesshowcase.debugclient.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductTemplate {
    private String templatename;
    private List<ConfigurableField> fields;
}
