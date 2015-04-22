package com.psidox.garage.service;

import com.psidox.garage.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.net.CacheRequest;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    Car findById(long id);
    List<CacheRequest> findByCarModel(@Param("model") int model);

}

