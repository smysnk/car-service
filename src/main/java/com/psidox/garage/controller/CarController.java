package com.psidox.garage.controller;

import com.psidox.garage.resource.CarResource;
import com.psidox.garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping(method = RequestMethod.GET)
    public List<CarResource> getAll() {

        return this.carService.getAll();

    }

    @RequestMapping(value = "/{serviceRecordId}", method = RequestMethod.GET)
    public CarResource findOne(@PathVariable("serviceRecordId") long id) {

        return this.carService.getCarResource(id);

    }


    
}

