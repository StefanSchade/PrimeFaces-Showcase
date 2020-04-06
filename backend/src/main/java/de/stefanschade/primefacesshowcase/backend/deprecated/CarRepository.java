package de.stefanschade.primefacesshowcase.backend.deprecated;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Deprecated
@Repository
public interface CarRepository extends CrudRepository<CarEntity,Long> {

    @Override
    Optional<CarEntity> findById(Long aLong);



}
