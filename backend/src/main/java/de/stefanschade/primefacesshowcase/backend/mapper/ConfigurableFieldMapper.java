package de.stefanschade.primefacesshowcase.backend.mapper;

import de.stefanschade.primefacesshowcase.backend.entities.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.dto.ConfigurableFieldDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConfigurableFieldMapper {

    de.stefanschade.primefacesshowcase.backend.mapper.ProductTemplateMapper INSTANCE = Mappers.getMapper(de.stefanschade.primefacesshowcase.backend.mapper.ProductTemplateMapper.class);

    ConfigurableFieldDto configurableFieldDtoToConfigurableFieldEntity(ConfigurableFieldEntity configurableFieldEntity);

}


