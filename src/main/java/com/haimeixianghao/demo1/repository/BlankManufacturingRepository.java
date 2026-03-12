package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.BlankManufacturing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlankManufacturingRepository extends CrudRepository<BlankManufacturing, Long> {
}

