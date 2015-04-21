package carService.service;

import carService.resource.CarResource;
import carService.resource.CarResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("carService")
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarResourceAssembler carResourceAssembler;


    public CarResource getCarResource(long id) {

        return carResourceAssembler.toResource(this.carRepository.findOne(id));

    }

}
