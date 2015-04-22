package com.psidox.garage.service;

import com.psidox.garage.model.Car;
import com.psidox.garage.model.Customer;
import com.psidox.garage.model.ServiceRecord;
import com.psidox.garage.service.exception.ExceptionCannotChangeOil;
import com.psidox.garage.service.exception.ExceptionCannotChangeSparkplug;
import com.psidox.garage.service.exception.ExceptionNotOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Component("serviceRecordService")
@Transactional
public class ServiceRecordService {


    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    public List<ServiceRecord> getAll() {

        return this.serviceRecordRepository.findAll();

    }

    public ServiceRecord getOne(long serviceRecordId) {

        return this.serviceRecordRepository.findOne(serviceRecordId);

    }

    public void delete(long serviceRecordId) {

        ServiceRecord serviceRecord = this.serviceRecordRepository.findOne(serviceRecordId);
        this.serviceRecordRepository.delete(serviceRecord);

    }

    public ServiceRecord add(long customerId, long carId, int odometerReading, boolean oilChanged, boolean tireRoated, boolean sparkplugsChanged) throws Exception {

        ServiceRecord serviceRecord = new ServiceRecord();
        Car car = carRepository.findOne(carId);
        Customer customer = customerRepository.findOne(customerId);

        serviceRecord.setCar(car);
        serviceRecord.setCustomer(customer);
        serviceRecord.setDateServiced(new Date());
        serviceRecord.setOdometerReading(odometerReading);
        serviceRecord.setServiceOilChanged(oilChanged);
        serviceRecord.setServiceTireRotated(tireRoated);
        serviceRecord.setServiceSparkPlugsChanged(sparkplugsChanged);

        if (car.getCustomer() != customer) {
            throw new ExceptionNotOwner("Customer does not own this car");
        }

        if (!serviceRecord.getCar().getCarModel().getCarType().hasOil()
                && serviceRecord.isServiceOilChanged()) {
            throw new ExceptionCannotChangeOil("Cannot change oil on a car that doesn't have any.");
        }

        if (!serviceRecord.getCar().getCarModel().getCarType().hasSparkplugs()
                && serviceRecord.isServiceSparkPlugsChanged()) {
            throw new ExceptionCannotChangeSparkplug("Cannot change sparkplugs on a car that doesn't have any.");
        }

        this.serviceRecordRepository.save(serviceRecord);
        return serviceRecord;

    }




}
