package de.stefanschade.PrimeFacesShowcase.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTemplateResponseModel {

    private String templatename;
    private List<ConfigurableFieldResponseModel> fieldsmodel;
}
