package com.psidox.garage.resource;

import com.psidox.garage.controller.CarController;
import com.psidox.garage.model.Car;
import com.psidox.garage.model.CarMake;
import com.psidox.garage.model.CarModel;
import com.psidox.garage.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CarResourceAssembler extends ResourceAssemblerSupport<Car, CarResource> {

    @Autowired
    CustomerResourceAssembler customerResourceAssembler;

    public CarResourceAssembler() {
        super(CarController.class, CarResource.class);
    }

    @Override
    public CarResource toResource(Car car) {

        // will add also a link with rel self pointing itself
        CarResource resource = createResourceWithId(car.getId(), car);

        CarModel carModel = car.getCarModel();
        CarMake carMake = car.getCarModel().getCarMake();
        CarType carType = car.getCarModel().getCarType();

        resource.setModel(carModel.getName());
        resource.setMake(carMake.getName());
        resource.setType(carType.getName());
        resource.setYear(car.getYear());
        resource.setHasOil(carType.hasOil());
        resource.setHasSparkplugs(carType.hasSparkplugs());

        resource.setCustomer(customerResourceAssembler.toResource(car.getCustomer()));

//        resource.add(linkTo(methodOn(ServiceRecordResource.class).getAuthorBooks(serviceRecord.getAuthorId())).withRel("books"));

        return resource;

    }


    @Override
    protected CarResource instantiateResource(Car car) {
        return new CarResource(car.getId());
    }


}
