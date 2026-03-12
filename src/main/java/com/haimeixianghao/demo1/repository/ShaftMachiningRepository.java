package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.ShaftMachining;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShaftMachiningRepository extends CrudRepository<ShaftMachining, Long> {
}

