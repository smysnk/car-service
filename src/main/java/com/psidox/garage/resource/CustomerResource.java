package com.psidox.garage.resource;


import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport {

    private long customerId;

    private String firstName;
    private String lastName;

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

}
