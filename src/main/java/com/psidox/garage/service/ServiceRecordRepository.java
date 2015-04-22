package com.psidox.garage.service;

import com.psidox.garage.model.ServiceRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ServiceRecordRepository extends PagingAndSortingRepository<ServiceRecord, Long> {

    Page<ServiceRecord> findAll(Pageable pageable);

    List<ServiceRecord> findAll();

    ServiceRecord findById(long id);

}
