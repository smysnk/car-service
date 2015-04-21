package carService.controller;

import carService.resource.CarResource;
import carService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/car")
@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping(value = "/{serviceRecordId}", method = RequestMethod.GET)
    public CarResource findOne(@PathVariable("serviceRecordId") long id) {

        return this.carService.getCarResource(id);

    }

    
}

