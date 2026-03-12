package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.WorkingProcedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingProcedureRepository extends CrudRepository<WorkingProcedure, Long> {
    List<WorkingProcedure> findByProcedureCodeContainingIgnoreCase(String procedureCode);
    List<WorkingProcedure> findByProcedureNameContainingIgnoreCase(String procedureName);
}

