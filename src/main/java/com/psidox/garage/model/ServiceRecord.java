package com.psidox.garage.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ServiceRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Date dateServiced;
    private Integer odometerReading;
    private Boolean serviceOilChanged = false;
    private Boolean serviceTireRotated = false;
    private Boolean serviceSparkPlugsChanged = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateServiced() {
        return dateServiced;
    }

    public void setDateServiced(Date dateServiced) {
        this.dateServiced = dateServiced;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public Boolean isServiceOilChanged() {
        return serviceOilChanged;
    }

    public void setServiceOilChanged(Boolean serviceOilChanged) throws Exception {

//        if (serviceOilChanged && !this.car.getCarModel().getCarType().hasOil())
//            throw new Exception("This car does not have oil to change");

        this.serviceOilChanged = serviceOilChanged;
    }

    public Boolean isServiceTireRotated() {
        return serviceTireRotated;
    }

    public void setServiceTireRotated(Boolean serviceTireRotated) {
        this.serviceTireRotated = serviceTireRotated;
    }

    public Boolean isServiceSparkPlugsChanged() {
        return serviceSparkPlugsChanged;
    }

    public void setServiceSparkPlugsChanged(Boolean serviceSparkPlugsChanged) throws Exception {

//        if (serviceSparkPlugsChanged && !this.car.getCarModel().getCarType().hasSparkplugs())
//            throw new Exception("This car does not have spark plugs to change");

        this.serviceSparkPlugsChanged = serviceSparkPlugsChanged;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTest() {
        String make = getCar().getCarModel().getCarMake().getName();
        String model = getCar().getCarModel().getName();
        Integer year = getCar().getYear();
        return year.toString() + " " + make + " " + model;
    }

}
