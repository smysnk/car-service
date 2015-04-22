package com.psidox.garage.resource;


import org.springframework.hateoas.ResourceSupport;

public class CarResource extends ResourceSupport {

    private long carId;
    private String make;
    private String model;
    private String type;
    private Integer year;
    private boolean hasOil;
    private boolean hasSparkplugs;
    private CustomerResource customer;

    public CarResource(long carId) {
        this.carId = carId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean isHasOil() {
        return hasOil;
    }

    public void setHasOil(boolean hasOil) {
        this.hasOil = hasOil;
    }

    public boolean isHasSparkplugs() {
        return hasSparkplugs;
    }

    public void setHasSparkplugs(boolean hasSparkplugs) {
        this.hasSparkplugs = hasSparkplugs;
    }

    public CustomerResource getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResource customer) {
        this.customer = customer;
    }
}
