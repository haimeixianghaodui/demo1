package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.WorkingProcedureDto;
import com.haimeixianghao.demo1.entity.WorkingProcedure;
import com.haimeixianghao.demo1.repository.WorkingProcedureRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingProcedureService {

    private final WorkingProcedureRepository repository;

    public WorkingProcedureService(WorkingProcedureRepository repository) {
        this.repository = repository;
    }

    public WorkingProcedureDto create(WorkingProcedureDto dto) {
        WorkingProcedure e = toEntity(dto);
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public WorkingProcedureDto getById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<WorkingProcedureDto> findAll() {
        List<WorkingProcedureDto> list = new ArrayList<>();
        repository.findAll().forEach(p -> list.add(toDto(p)));
        return list;
    }

    public List<WorkingProcedureDto> search(String q) {
        List<WorkingProcedure> byCode = repository.findByProcedureCodeContainingIgnoreCase(q);
        List<WorkingProcedure> byName = repository.findByProcedureNameContainingIgnoreCase(q);
        List<WorkingProcedureDto> result = new ArrayList<>();
        byCode.forEach(p -> result.add(toDto(p)));
        byName.stream().filter(p -> byCode.stream().noneMatch(c -> c.getId().equals(p.getId())))
                .forEach(p -> result.add(toDto(p)));
        return result;
    }

    public WorkingProcedureDto update(Long id, WorkingProcedureDto dto) {
        Optional<WorkingProcedure> o = repository.findById(id);
        if (o.isEmpty()) return null;
        WorkingProcedure e = o.get();
        e.setProcedureCode(dto.getProcedureCode());
        e.setProcedureName(dto.getProcedureName());
        e.setOperator(dto.getOperator());
        e.setProductionStep(dto.getProductionStep());
        e.setPlan2PartId(dto.getPlan2PartId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private WorkingProcedure toEntity(WorkingProcedureDto dto) {
        WorkingProcedure e = new WorkingProcedure();
        e.setProcedureCode(dto.getProcedureCode());
        e.setProcedureName(dto.getProcedureName());
        e.setOperator(dto.getOperator());
        e.setProductionStep(dto.getProductionStep());
        e.setPlan2PartId(dto.getPlan2PartId());
        return e;
    }

    private WorkingProcedureDto toDto(WorkingProcedure e) {
        WorkingProcedureDto dto = new WorkingProcedureDto();
        dto.setId(e.getId());
        dto.setProcedureCode(e.getProcedureCode());
        dto.setProcedureName(e.getProcedureName());
        dto.setStartTime(e.getStartTime() != null ? e.getStartTime().toString() : null);
        dto.setEndTime(e.getEndTime() != null ? e.getEndTime().toString() : null);
        dto.setOperator(e.getOperator());
        dto.setProductionStep(e.getProductionStep());
        dto.setPlan2PartId(e.getPlan2PartId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

