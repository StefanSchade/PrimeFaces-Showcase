package de.stefanschade.PrimeFacesShowcase.backend.repositories;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigurableFieldRepository extends CrudRepository<ConfigurableFieldEntity,Long>  {

    Iterable<ConfigurableFieldEntity> findAll();

}
