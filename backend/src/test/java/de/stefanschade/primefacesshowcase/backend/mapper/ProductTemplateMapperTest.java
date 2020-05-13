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

    ProductTemplateMapper productTemplateMapper = ProductTemplateMapper.INSTANCE;

    @Test
    public void productTemplateEntityToProductTemplateDto() throws Exception {

        //given
        ProductTemplateEntity productTemplateEntity = new ProductTemplateEntity("template");
        ConfigurableFieldEntity configurableFieldEntity1 = new ConfigurableFieldEntity(productTemplateEntity, "field1", FieldType.DOUBLE);
        ConfigurableFieldEntity configurableFieldEntity2 = new ConfigurableFieldEntity(productTemplateEntity, "field2", FieldType.STRING);
        List<ConfigurableFieldEntity> configurableFieldEntityList = new ArrayList<>(2);
        configurableFieldEntityList.add(configurableFieldEntity1);
        configurableFieldEntityList.add(configurableFieldEntity2);
        productTemplateEntity.setFields(configurableFieldEntityList);

        //when
        ProductTemplateDto productTemplateDto = productTemplateMapper.productTemplateEntityToProductTemplateDto(productTemplateEntity);

        //then
        assertEquals("template", productTemplateDto.getTemplatename());
        assertEquals(Integer.valueOf(2), productTemplateDto.getFieldsdto().size());
        assertEquals("field1",productTemplateDto.getFieldsdto().get(0).getFieldname());

    }
}