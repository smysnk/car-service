package com.psidox.garage;

import com.psidox.garage.controller.ServiceRecordController;
import com.psidox.garage.service.ServiceRecordRepository;
import com.psidox.garage.service.ServiceRecordService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ServiceRecordControllerTest {

	@InjectMocks
	ServiceRecordController serviceRecordController;

	@Mock
	ServiceRecordRepository serviceRecordRepository;

	@Mock
	ServiceRecordService serviceRecordService;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(serviceRecordController).build();

//		when(serviceRecordService.getServiceRecords()).thenReturn()
//		Mockito.when(serviceRecordRepository.findAll(an).thenReturn("");

	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/service-record")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("{\"make\":\"Ford\",\"model\":\"GT\",\"year\":2015}")));
	}

}
