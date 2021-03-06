package de.stefanschade.primefacesshowcase.frontend.beans.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

@Slf4j
@Named
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTemplate {

    private int fieldCount;

    private String templatename;

    private List<ConfigurableField> fields;
}
