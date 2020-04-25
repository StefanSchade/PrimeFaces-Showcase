package de.stefanschade.primefacesshowcase.debugclient.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTemplate {
    private String templatename;
    private List<ConfigurableField> fields;
}
