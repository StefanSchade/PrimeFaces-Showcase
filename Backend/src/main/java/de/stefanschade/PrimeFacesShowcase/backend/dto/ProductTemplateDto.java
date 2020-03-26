package de.stefanschade.PrimeFacesShowcase.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class ProductTemplateDto {

    private String id;
    private String categoryName;

}
