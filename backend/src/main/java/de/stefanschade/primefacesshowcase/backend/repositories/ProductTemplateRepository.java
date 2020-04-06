package de.stefanschade.primefacesshowcase.backend.repositories;

import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTemplateRepository extends CrudRepository<ProductTemplateEntity, Long> {
    Iterable<ProductTemplateEntity> findAll();
}
