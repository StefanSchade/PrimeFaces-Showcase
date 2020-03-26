package de.stefanschade.backend.model.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ProductCategoryResponseModel {

    private Long id;
    private String categoryName;

}
