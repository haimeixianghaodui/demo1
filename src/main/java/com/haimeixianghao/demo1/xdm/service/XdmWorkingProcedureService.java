package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.WorkingProcedureDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmWorkingProcedureService {

    private static final String ENTITY = "WorkingProcedure";
    private final XdmClient client;

    public XdmWorkingProcedureService(XdmClient client) {
        this.client = client;
    }

    public WorkingProcedureDto create(WorkingProcedureDto dto) {
        WorkingProcedureCreateDTO xdm = new WorkingProcedureCreateDTO();
        xdm.setProcedureCode(dto.getProcedureCode());
        xdm.setProcedureName(dto.getProcedureName());
        xdm.setOperator(dto.getOperator());
        xdm.setProductionStep(dto.getProductionStep());
        if (dto.getPlan2PartId() != null) {
            xdm.setPlan2Part(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getPlan2PartId())));
        }
        WorkingProcedureViewDTO view = client.create(ENTITY, xdm, WorkingProcedureViewDTO.class);
        return toDto(view);
    }

    public WorkingProcedureDto getById(Long id) {
        WorkingProcedureViewDTO view = client.get(ENTITY, String.valueOf(id), WorkingProcedureViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<WorkingProcedureDto> findAll() {
        return client.findAll(ENTITY, WorkingProcedureViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<WorkingProcedureDto> search(String q) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("procedureCode", "like", "%" + q + "%")
        ));
        return client.find(ENTITY, query, 1, 10000, WorkingProcedureViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public WorkingProcedureDto update(Long id, WorkingProcedureDto dto) {
        WorkingProcedureViewDTO existing = client.get(ENTITY, String.valueOf(id), WorkingProcedureViewDTO.class);
        if (existing == null) return null;
        WorkingProcedureUpdateDTO xdm = new WorkingProcedureUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        xdm.setProcedureCode(dto.getProcedureCode());
        xdm.setProcedureName(dto.getProcedureName());
        xdm.setOperator(dto.getOperator());
        xdm.setProductionStep(dto.getProductionStep());
        if (dto.getPlan2PartId() != null) {
            xdm.setPlan2Part(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getPlan2PartId())));
        }
        WorkingProcedureViewDTO view = client.update(ENTITY, xdm, WorkingProcedureViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private WorkingProcedureDto toDto(WorkingProcedureViewDTO v) {
        WorkingProcedureDto dto = new WorkingProcedureDto();
        dto.setId(parseLong(v.getId()));
        dto.setProcedureCode(v.getProcedureCode());
        dto.setProcedureName(v.getProcedureName());
        dto.setStartTime(v.getStartTime());
        dto.setEndTime(v.getEndTime());
        dto.setOperator(v.getOperator());
        dto.setProductionStep(v.getProductionStep());
        if (v.getPlan2Part() != null) {
            dto.setPlan2PartId(parseLong(v.getPlan2Part().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
