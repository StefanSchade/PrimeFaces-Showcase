package de.stefanschade.backend.repositories;

import de.stefanschade.backend.domain.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<CarEntity,Long> {

    @Override
    Optional<CarEntity> findById(Long aLong);



}
