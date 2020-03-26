package de.stefanschade.PrimeFacesShowcase.backend.repositories;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductTemplateRepository extends CrudRepository<ProductTemplateEntity, Long> {

    ProductTemplateEntity findById(String id);

    Iterable<ProductTemplateEntity> findAll();

}
