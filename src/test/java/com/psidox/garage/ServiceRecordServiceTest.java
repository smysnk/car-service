package com.psidox.garage;

import com.psidox.garage.model.Car;
import com.psidox.garage.model.Customer;
import com.psidox.garage.model.ServiceRecord;
import com.psidox.garage.service.CarRepository;
import com.psidox.garage.service.CustomerRepository;
import com.psidox.garage.service.ServiceRecordService;
import com.psidox.garage.service.exception.ExceptionCannotChangeOil;
import com.psidox.garage.service.exception.ExceptionCannotChangeSparkplug;
import com.psidox.garage.service.exception.ExceptionNotOwner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ServiceRecordServiceTest {

	@Autowired
	CarRepository carRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ServiceRecordService serviceRecordService;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void shouldAddWithoutException() throws Exception {

		ServiceRecord serviceRecord = serviceRecordService.addServiceRecord(1, 1, 1000, true, true, true);
		assertEquals(serviceRecord.isServiceOilChanged(), true);
		assertEquals(serviceRecord.isServiceTireRotated(), true);
		assertEquals(serviceRecord.isServiceSparkPlugsChanged(), true);
		assertThat(serviceRecord.getOdometerReading(), equalTo(1000));
		assertThat(serviceRecord.getCar().getId(), equalTo(1L));
		assertThat(serviceRecord.getCar().getId(), equalTo(1L));

	}

	public void shouldAllowOilChangeForGas() throws Exception {

		// Get a gas car
		Car car = carRepository.findOne(1L);
		assertEquals(car.getCarModel().getCarType().getName(), "Gas");
		assertEquals(car.getCarModel().getCarType().hasOil(), true);

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, true, false, false);

	}

	public void shouldAllowOilChangeForHybrid() throws Exception {

		// Get a hybrid car
		Car car = carRepository.findOne(3L);
		assertEquals(car.getCarModel().getCarType().getName(), "Hybrid");
		assertEquals(car.getCarModel().getCarType().hasOil(), true);

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, true, false, false);

	}

	@Test(expected = ExceptionCannotChangeOil.class)
	public void shouldNotAllowOilChangeForElectric() throws Exception {

		// Get a electric car
		Car car = carRepository.findOne(4L);
		assertEquals(car.getCarModel().getCarType().getName(), "Electric");
		assertEquals(car.getCarModel().getCarType().hasOil(), false);

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, true, false, false);

	}


	public void shouldAllowSparkplugChangeForGas() throws Exception {

		// Get a electric car
		Car car = carRepository.findOne(1L);
		assertEquals(car.getCarModel().getCarType().getName(), "Gas");
		assertEquals(car.getCarModel().getCarType().hasSparkplugs(), true);

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, false, false, true);

	}

	@Test(expected = ExceptionCannotChangeSparkplug.class)
	public void shouldNotAllowSparkplugChangeForElectric() throws Exception {

		// Get a electric car
		Car car = carRepository.findOne(4L);
		assertEquals(car.getCarModel().getCarType().getName(), "Electric");

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, false, false, true);

	}

	@Test(expected = ExceptionCannotChangeSparkplug.class)
	public void shouldNotAllowSparkplugChangeForDiesel() throws Exception {

		// Get a diesel truck
		Car car = carRepository.findOne(2L);
		assertEquals(car.getCarModel().getCarType().getName(), "Diesel");

		serviceRecordService.addServiceRecord(1, car.getId(), 1000, false, false, true);

	}

	@Test(expected = ExceptionNotOwner.class)
	public void shouldNotAllowAddingCarToWrongCustomer() throws Exception {

		// Get a car that belongs to somebody else
		Car car = carRepository.findOne(5L);
		Customer customer = customerRepository.findOne(1L);
		assertNotEquals(car.getCustomer(), customer);

		serviceRecordService.addServiceRecord(customer.getId(), car.getId(), 1000, false, false, true);

	}

}
