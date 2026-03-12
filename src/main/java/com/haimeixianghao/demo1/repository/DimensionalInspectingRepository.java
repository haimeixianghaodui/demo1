package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.DimensionalInspecting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionalInspectingRepository extends CrudRepository<DimensionalInspecting, Long> {
}

