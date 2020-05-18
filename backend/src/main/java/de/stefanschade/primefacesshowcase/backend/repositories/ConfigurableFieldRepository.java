package de.stefanschade.primefacesshowcase.backend.repositories;

import de.stefanschade.primefacesshowcase.backend.entities.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.entities.ProductTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConfigurableFieldRepository extends CrudRepository<ConfigurableFieldEntity,Long>  {

    List<ConfigurableFieldEntity> findByTemplate(ProductTemplateEntity template);

    Iterable<ConfigurableFieldEntity> findAll();

}
