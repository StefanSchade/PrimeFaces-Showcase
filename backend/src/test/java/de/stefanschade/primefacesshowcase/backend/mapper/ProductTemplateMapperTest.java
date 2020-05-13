package de.stefanschade.primefacesshowcase.backend.mapper;

import de.stefanschade.primefacesshowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductTemplateMapperTest {

    public static final String NAME_TEMPLATE = "template";
    public static final String NAME_FIELD_1 = "field1";
    public static final String NAME_FIELD_2 = "field2";
    public static final Integer NR_OF_FIELDS = Integer.valueOf(2);

    ProductTemplateMapper productTemplateMapper = ProductTemplateMapper.INSTANCE;

    @Test
    public void productTemplateEntityToProductTemplateDto() throws Exception {

        //given
        ProductTemplateEntity productTemplateEntity = new ProductTemplateEntity(NAME_TEMPLATE);
        ConfigurableFieldEntity configurableFieldEntity1 = new ConfigurableFieldEntity(productTemplateEntity, NAME_FIELD_1, FieldType.DOUBLE);
        ConfigurableFieldEntity configurableFieldEntity2 = new ConfigurableFieldEntity(productTemplateEntity, NAME_FIELD_2, FieldType.STRING);
        List<ConfigurableFieldEntity> configurableFieldEntityList = new ArrayList<>(NR_OF_FIELDS);
        configurableFieldEntityList.add(configurableFieldEntity1);
        configurableFieldEntityList.add(configurableFieldEntity2);
        productTemplateEntity.setFields(configurableFieldEntityList);

        //when
        ProductTemplateDto productTemplateDto = productTemplateMapper.productTemplateEntityToProductTemplateDto(productTemplateEntity);

        //then
        assertEquals(NAME_TEMPLATE, productTemplateDto.getTemplatename());
        assertEquals(NR_OF_FIELDS, productTemplateDto.getFieldsdto().size());
        assertEquals(NAME_FIELD_1,productTemplateDto.getFieldsdto().get(0).getFieldname());

    }
}