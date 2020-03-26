package de.stefanschade.PrimeFacesShowcase.backend.repositories;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurationFieldEntity;
import org.springframework.data.repository.CrudRepository;

public interface ConfigurationFieldRepository extends CrudRepository<ConfigurationFieldEntity,Long>  {

    ConfigurationFieldEntity findById(String id);

    Iterable<ConfigurationFieldEntity> findAll();

}
