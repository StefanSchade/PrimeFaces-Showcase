package de.stefanschade.backend.model.reqest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ProductCategoryRequestModel {

    private String id;
    private String categoryName;

}
