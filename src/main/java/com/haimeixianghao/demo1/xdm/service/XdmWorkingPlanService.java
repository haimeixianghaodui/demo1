package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.WorkingPlanDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmWorkingPlanService {

    private static final String ENTITY = "WorkingPlan";
    private final XdmClient client;

    public XdmWorkingPlanService(XdmClient client) {
        this.client = client;
    }

    public WorkingPlanDto create(WorkingPlanDto dto) {
        WorkingPlanCreateDTO xdm = new WorkingPlanCreateDTO();
        xdm.setPlanCode(dto.getPlanCode());
        xdm.setPlanName(dto.getPlanName());
        xdm.setVersion(dto.getVersion());
        xdm.setEquipmentUsage(dto.getEquipmentUsage());
        xdm.setOperator(dto.getOperator());
        if (dto.getPlan1PartId() != null) {
            xdm.setPlan1Part(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getPlan1PartId())));
        }
        WorkingPlanViewDTO view = client.create(ENTITY, xdm, WorkingPlanViewDTO.class);
        return toDto(view);
    }

    public WorkingPlanDto getById(Long id) {
        WorkingPlanViewDTO view = client.get(ENTITY, String.valueOf(id), WorkingPlanViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<WorkingPlanDto> findAll() {
        return client.findAll(ENTITY, WorkingPlanViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<WorkingPlanDto> search(String q) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("planCode", "like", "%" + q + "%")
        ));
        return client.find(ENTITY, query, 1, 10000, WorkingPlanViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public WorkingPlanDto update(Long id, WorkingPlanDto dto) {
        WorkingPlanViewDTO existing = client.get(ENTITY, String.valueOf(id), WorkingPlanViewDTO.class);
        if (existing == null) return null;
        WorkingPlanUpdateDTO xdm = new WorkingPlanUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        xdm.setPlanCode(dto.getPlanCode());
        xdm.setPlanName(dto.getPlanName());
        xdm.setVersion(dto.getVersion());
        xdm.setEquipmentUsage(dto.getEquipmentUsage());
        xdm.setOperator(dto.getOperator());
        if (dto.getPlan1PartId() != null) {
            xdm.setPlan1Part(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getPlan1PartId())));
        }
        WorkingPlanViewDTO view = client.update(ENTITY, xdm, WorkingPlanViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private WorkingPlanDto toDto(WorkingPlanViewDTO v) {
        WorkingPlanDto dto = new WorkingPlanDto();
        dto.setId(parseLong(v.getId()));
        dto.setPlanCode(v.getPlanCode());
        dto.setPlanName(v.getPlanName());
        dto.setVersion(v.getVersion());
        dto.setOperationTime(v.getOperationTime());
        dto.setEquipmentUsage(v.getEquipmentUsage());
        dto.setOperator(v.getOperator());
        if (v.getPlan1Part() != null) {
            dto.setPlan1PartId(parseLong(v.getPlan1Part().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
