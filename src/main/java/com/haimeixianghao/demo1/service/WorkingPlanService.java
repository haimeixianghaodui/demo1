package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.dto.WorkingPlanDto;
import com.haimeixianghao.demo1.entity.WorkingPlan;
import com.haimeixianghao.demo1.repository.WorkingPlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkingPlanService {

    private final WorkingPlanRepository repository;

    public WorkingPlanService(WorkingPlanRepository repository) {
        this.repository = repository;
    }

    public WorkingPlanDto create(WorkingPlanDto dto) {
        WorkingPlan e = toEntity(dto);
        e.setCreateTime(LocalDateTime.now());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public WorkingPlanDto getById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    public List<WorkingPlanDto> findAll() {
        List<WorkingPlanDto> list = new ArrayList<>();
        repository.findAll().forEach(p -> list.add(toDto(p)));
        return list;
    }

    public List<WorkingPlanDto> search(String q) {
        List<WorkingPlan> byCode = repository.findByPlanCodeContainingIgnoreCase(q);
        List<WorkingPlan> byName = repository.findByPlanNameContainingIgnoreCase(q);
        List<WorkingPlanDto> result = new ArrayList<>();
        byCode.forEach(p -> result.add(toDto(p)));
        byName.stream().filter(p -> byCode.stream().noneMatch(c -> c.getId().equals(p.getId())))
                .forEach(p -> result.add(toDto(p)));
        return result;
    }

    public WorkingPlanDto update(Long id, WorkingPlanDto dto) {
        Optional<WorkingPlan> o = repository.findById(id);
        if (o.isEmpty()) return null;
        WorkingPlan e = o.get();
        e.setPlanCode(dto.getPlanCode());
        e.setPlanName(dto.getPlanName());
        e.setVersion(dto.getVersion());
        e.setEquipmentUsage(dto.getEquipmentUsage());
        e.setOperator(dto.getOperator());
        e.setPlan1PartId(dto.getPlan1PartId());
        e.setLastUpdateTime(LocalDateTime.now());
        return toDto(repository.save(e));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private WorkingPlan toEntity(WorkingPlanDto dto) {
        WorkingPlan e = new WorkingPlan();
        e.setPlanCode(dto.getPlanCode());
        e.setPlanName(dto.getPlanName());
        e.setVersion(dto.getVersion());
        e.setEquipmentUsage(dto.getEquipmentUsage());
        e.setOperator(dto.getOperator());
        e.setPlan1PartId(dto.getPlan1PartId());
        return e;
    }

    private WorkingPlanDto toDto(WorkingPlan e) {
        WorkingPlanDto dto = new WorkingPlanDto();
        dto.setId(e.getId());
        dto.setPlanCode(e.getPlanCode());
        dto.setPlanName(e.getPlanName());
        dto.setVersion(e.getVersion());
        dto.setOperationTime(e.getOperationTime() != null ? e.getOperationTime().toString() : null);
        dto.setEquipmentUsage(e.getEquipmentUsage());
        dto.setOperator(e.getOperator());
        dto.setPlan1PartId(e.getPlan1PartId());
        dto.setCreateTime(e.getCreateTime() != null ? e.getCreateTime().toString() : null);
        dto.setLastUpdateTime(e.getLastUpdateTime() != null ? e.getLastUpdateTime().toString() : null);
        return dto;
    }
}

