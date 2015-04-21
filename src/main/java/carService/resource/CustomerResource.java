package carService.resource;


import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class CustomerResource extends ResourceSupport {

    private long customerId;

    private String firstName;
    private String lastName;

    private List<CarResource> cars;
    private List<ServiceRecordResource> serviceRecords;

    public CustomerResource(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CarResource> getCars() {
        return cars;
    }

    public void setCars(List<CarResource> cars) {
        this.cars = cars;
    }

    public List<ServiceRecordResource> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(List<ServiceRecordResource> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }

}
