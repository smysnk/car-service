package carService.controller;

import carService.resource.CustomerResource;
import carService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/{serviceRecordId}", method = RequestMethod.GET)
    public CustomerResource findOne(@PathVariable("serviceRecordId") long id) {

        return this.customerService.getCustomerResource(id);

    }
    
}