package de.stefanschade.PrimeFacesShowcase.frontend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

@Slf4j
@Named
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductTemplate {
    private String templatename;
    private List<ConfigurableField> fields;
}
