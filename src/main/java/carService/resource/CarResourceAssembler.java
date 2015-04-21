package carService.resource;

import carService.controller.CarController;
import carService.model.Car;
import carService.model.CarMake;
import carService.model.CarModel;
import carService.model.CarType;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CarResourceAssembler extends ResourceAssemblerSupport<Car, CarResource> {

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

        return resource;

    }


    @Override
    protected CarResource instantiateResource(Car car) {
        return new CarResource(car.getId());
    }


}
