package carService.service;

import carService.model.ServiceRecord;
import carService.resource.ServiceRecordResource;
import carService.resource.ServiceRecordResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component("serviceRecordService")
@Transactional
public class ServiceRecordService {

    @Autowired
    private ServiceRecordRepository serviceRecordRepository;

    @Autowired
    private ServiceRecordResourceAssembler serviceRecordResourceAssembler;

    public Page<ServiceRecord> getServiceRecords(Pageable pageable) {

        return serviceRecordRepository.findAll(pageable);

    }

    public ServiceRecord addServiceRecord(ServiceRecord serviceRecord) {

        serviceRecordRepository.save(serviceRecord);
        return serviceRecord;

    }

    public ServiceRecordResource getServiceRecord(long id) {

        return serviceRecordResourceAssembler.toResource(this.serviceRecordRepository.findOne(id));

    }

}
