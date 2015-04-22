package com.psidox.garage.service;

import com.psidox.garage.resource.CarResource;
import com.psidox.garage.resource.CarResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("carService")
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarResourceAssembler carResourceAssembler;

    public List<CarResource> getAll() {

        return this.carResourceAssembler.toResources(this.carRepository.findAll());

    }

    public CarResource getCarResource(long id) {

        return carResourceAssembler.toResource(this.carRepository.findOne(id));

    }


}
