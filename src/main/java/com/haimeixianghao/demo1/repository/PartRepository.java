package com.haimeixianghao.demo1.repository;

import com.haimeixianghao.demo1.entity.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends CrudRepository<Part, Long> {
    List<Part> findByPartCodeContainingIgnoreCase(String partCode);
    List<Part> findByPartNameContainingIgnoreCase(String partName);
}

