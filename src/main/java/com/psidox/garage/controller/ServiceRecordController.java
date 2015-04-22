package com.psidox.garage.controller;

import com.psidox.garage.model.ServiceRecord;
import com.psidox.garage.resource.PageResource;
import com.psidox.garage.resource.ServiceRecordResource;
import com.psidox.garage.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/service-record")
@RestController
public class ServiceRecordController {

    @Autowired
    private ServiceRecordService serviceRecordService;
    
    @RequestMapping(method = RequestMethod.GET)
    public PageResource<ServiceRecord> index(
            @RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "10") int size) {

        Pageable pageable = new PageRequest(
            page, size, new Sort("id")
        );

        Page<ServiceRecord> serviceRecords = serviceRecordService.getServiceRecords(pageable);
        return new PageResource<>(serviceRecords, "page", "size");

    }

    @RequestMapping(method = RequestMethod.POST)
    public ServiceRecordResource addServiceRecord(@RequestBody ServiceRecordResource serviceRecordResource) {

//        return serviceRecordService.addServiceRecord(serviceRecord);
        return serviceRecordResource;

    }

    @RequestMapping(value = "/{serviceRecordId}", method = RequestMethod.GET)
    public ServiceRecordResource findOne(@PathVariable("serviceRecordId") long id) {

        return this.serviceRecordService.getServiceRecord(id);

    }

    
}