package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.Warehousing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousingRepository extends CrudRepository<Warehousing, Long> {
}

