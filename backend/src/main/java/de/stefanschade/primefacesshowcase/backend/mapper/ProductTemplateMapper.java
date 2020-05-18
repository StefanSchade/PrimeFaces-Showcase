package de.stefanschade.primefacesshowcase.backend.mapper;

import de.stefanschade.primefacesshowcase.backend.entities.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.ProductTemplateDto;
import de.stefanschade.primefacesshowcase.backend.model.response.ProductTemplateResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductTemplateMapper {

    ProductTemplateMapper INSTANCE = Mappers.getMapper(ProductTemplateMapper.class);

    @Mapping(target = "fieldsdto", source = "fields")
    ProductTemplateDto productTemplateEntityToProductTemplateDto(ProductTemplateEntity productTemplateEntity);


    @Mapping(target = "fields", source = "fieldsdto")
    ProductTemplateResponseModel productTemplateDtoToProductTemplateResponseModel(ProductTemplateDto productTemplateDto);

}
