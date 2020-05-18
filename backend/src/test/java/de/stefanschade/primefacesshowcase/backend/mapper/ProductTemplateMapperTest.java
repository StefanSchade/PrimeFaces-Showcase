package de.stefanschade.primefacesshowcase.backend.mapper;

import de.stefanschade.primefacesshowcase.backend.entities.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.entities.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.model.response.ProductTemplateResponseModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductTemplateMapperTest {

    private static final String NAME_TEMPLATE = "template";
    private static final String NAME_FIELD_1 = "field1";
    private static final String NAME_FIELD_2 = "field2";
    private static final Integer NR_OF_FIELDS = Integer.valueOf(2);

    ProductTemplateMapper productTemplateMapper = ProductTemplateMapper.INSTANCE;

    public ProductTemplateEntity prepareProductTemplateEntity() {
        ProductTemplateEntity productTemplateEntity = new ProductTemplateEntity(NAME_TEMPLATE);
        ConfigurableFieldEntity configurableFieldEntity1 = new ConfigurableFieldEntity(productTemplateEntity, NAME_FIELD_1, FieldType.DOUBLE);
        ConfigurableFieldEntity configurableFieldEntity2 = new ConfigurableFieldEntity(productTemplateEntity, NAME_FIELD_2, FieldType.STRING);
        List<ConfigurableFieldEntity> configurableFieldEntityList = new ArrayList<>(NR_OF_FIELDS);
        configurableFieldEntityList.add(configurableFieldEntity1);
        configurableFieldEntityList.add(configurableFieldEntity2);
        productTemplateEntity.setFields(configurableFieldEntityList);
        return productTemplateEntity;
    }

    @Test
    public void productTemplateEntityToProductTemplateDto() throws Exception {
        //given
        ProductTemplateEntity productTemplateEntity = prepareProductTemplateEntity();

        //when
        ProductTemplateDto productTemplateDto = productTemplateMapper.productTemplateEntityToProductTemplateDto(productTemplateEntity);

        //then
        assertEquals(NAME_TEMPLATE, productTemplateDto.getTemplatename());
        assertEquals(NR_OF_FIELDS, productTemplateDto.getFieldsdto().size());
        assertEquals(NAME_FIELD_1, productTemplateDto.getFieldsdto().get(0).getFieldname());
    }


    @Test
    public void productTemplateDtoToProductTemplateResponseModel() throws Exception {
        //given
        ProductTemplateEntity productTemplateEntity = prepareProductTemplateEntity();
        ProductTemplateDto productTemplateDto = productTemplateMapper.productTemplateEntityToProductTemplateDto(productTemplateEntity);

        //when
        ProductTemplateResponseModel productTemplateResponseModel = productTemplateMapper.productTemplateDtoToProductTemplateResponseModel(productTemplateDto);

        //then
        assertEquals(NAME_TEMPLATE, productTemplateResponseModel.getTemplatename());
        assertEquals(NR_OF_FIELDS, productTemplateResponseModel.getFields().size());
        assertEquals(NAME_FIELD_1, productTemplateResponseModel.getFields().get(0).getFieldname());
    }

}