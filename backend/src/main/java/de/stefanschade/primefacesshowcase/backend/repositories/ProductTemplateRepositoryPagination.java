package de.stefanschade.primefacesshowcase.backend.repositories;

import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTemplateRepositoryPagination extends PagingAndSortingRepository<ProductTemplateEntity, Long> {
    Page<ProductTemplateEntity> findAll(Pageable pageable);
}