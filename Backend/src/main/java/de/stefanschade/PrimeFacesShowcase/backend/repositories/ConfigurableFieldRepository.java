package de.stefanschade.PrimeFacesShowcase.backend.repositories;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableFieldRepository extends CrudRepository<ConfigurableFieldEntity,Long>  {

//    ConfigurableFieldEntity findById(String id);

    Iterable<ConfigurableFieldEntity> findAll();

//    List<ConfigurableFieldEntity> findBytemplatenameAndFieldName(@Param("templatename")String templateName, @Param("field_name") String fieldName);

//    List<ConfigurableFieldEntity> findBytemplatename(@Param("templatename") String templateName);

}
