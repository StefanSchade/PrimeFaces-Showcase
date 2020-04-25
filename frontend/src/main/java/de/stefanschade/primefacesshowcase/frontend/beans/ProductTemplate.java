package de.stefanschade.primefacesshowcase.frontend.beans;

import de.stefanschade.primefacesshowcase.frontend.beans.ConfigurableField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

@Slf4j
@Named
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTemplate {
    private String templatename;
    private List<ConfigurableField> fields;
}
