package de.stefanschade.PrimeFacesShowcase.backend.repositories;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTemplateRepository extends CrudRepository<ProductTemplateEntity, Long> {

    Iterable<ProductTemplateEntity> findAll();
}
