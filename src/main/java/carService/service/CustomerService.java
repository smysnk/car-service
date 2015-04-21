package carService.service;

import carService.resource.CustomerResource;
import carService.resource.CustomerResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("customerService")
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerResourceAssembler customerResourceAssembler;

    public CustomerResource getCustomerResource(long id) {

        return customerResourceAssembler.toResource(this.customerRepository.findOne(id));

    }

}
