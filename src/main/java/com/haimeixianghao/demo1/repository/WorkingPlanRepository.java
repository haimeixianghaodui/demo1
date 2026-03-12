package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.WorkingPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingPlanRepository extends CrudRepository<WorkingPlan, Long> {
    List<WorkingPlan> findByPlanCodeContainingIgnoreCase(String planCode);
    List<WorkingPlan> findByPlanNameContainingIgnoreCase(String planName);
}

