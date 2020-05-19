package de.stefanschade.primefacesshowcase.frontend.beans.entities;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

@Slf4j
@Named
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductTemplate {
    private int fieldCount;
    private String templatename;
    private List<ConfigurableField> fields;

    public ProductTemplate deriveFieldsNotReceivedFromBackend() {
        this.setFieldCount(this.getFields().size());
        return this;
    }
}
