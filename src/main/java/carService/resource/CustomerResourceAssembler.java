package carService.resource;

import carService.controller.CustomerController;
import carService.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler extends ResourceAssemblerSupport<Customer, CustomerResource> {

    @Autowired
    CarResourceAssembler carResourceAssembler;

    @Autowired
    ServiceRecordResourceAssembler serviceRecordResourceAssembler;

    public CustomerResourceAssembler() {
        super(CustomerController.class, CustomerResource.class);
    }

    @Override
    public CustomerResource toResource(Customer customer) {

        CustomerResource resource = createResourceWithId(customer.getId(), customer);

        resource.setFirstName(customer.getFirstName());
        resource.setLastName(customer.getLastName());

        resource.setCars(carResourceAssembler.toResources(customer.getCars()));
        resource.setServiceRecords(serviceRecordResourceAssembler.toResources(customer.getServiceRecords()));

        return resource;

    }


    @Override
    protected CustomerResource instantiateResource(Customer customer) {
        return new CustomerResource(customer.getId());
    }


}
