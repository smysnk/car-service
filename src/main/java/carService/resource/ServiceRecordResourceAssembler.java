package carService.resource;

import carService.controller.ServiceRecordController;
import carService.model.ServiceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ServiceRecordResourceAssembler extends ResourceAssemblerSupport<ServiceRecord, ServiceRecordResource> {

    @Autowired
    private CarResourceAssembler carResourceAssembler;

    public ServiceRecordResourceAssembler() {
        super(ServiceRecordController.class, ServiceRecordResource.class);
    }

    @Override
    public ServiceRecordResource toResource(ServiceRecord serviceRecord) {

        // will add also a link with rel self pointing itself
        ServiceRecordResource resource = createResourceWithId(serviceRecord.getId(), serviceRecord);

        resource.setDateServiced(serviceRecord.getDateServiced());
        resource.setOdometerReading(serviceRecord.getOdometerReading());
        resource.setServiceTireRotated(serviceRecord.isServiceTireRotated());
        resource.setServiceOilChanged(serviceRecord.isServiceOilChanged());
        resource.setServiceSparkPlugsChanged(serviceRecord.isServiceSparkPlugsChanged());

        resource.setCars(carResourceAssembler.toResource(serviceRecord.getCar()));

        // adding a link with rel books pointing to the author's books
//        resource.add(linkTo(methodOn(ServiceRecordResource.class).getAuthorBooks(serviceRecord.getAuthorId())).withRel("books"));

        return resource;

    }



    @Override
    protected ServiceRecordResource instantiateResource(ServiceRecord serviceRecord) {
        return new ServiceRecordResource(serviceRecord.getId());
    }

}