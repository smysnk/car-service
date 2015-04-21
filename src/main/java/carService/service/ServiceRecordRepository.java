package carService.service;

import carService.model.ServiceRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRecordRepository extends PagingAndSortingRepository<ServiceRecord, Long> {

    Page<ServiceRecord> findAll(Pageable pageable);

    ServiceRecord findById(long id);

}
