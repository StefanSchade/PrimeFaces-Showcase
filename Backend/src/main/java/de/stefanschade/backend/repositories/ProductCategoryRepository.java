package de.stefanschade.backend.repositories;

import de.stefanschade.backend.domain.ProductCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategoryEntity, Long> {

    ProductCategoryEntity findById(String id);

    Iterable<ProductCategoryEntity> findAll();

}
