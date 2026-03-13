package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.DimensionalInspectingDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmDimensionalInspectingService {

    private static final String ENTITY = "Dimensional_inspecting";
    private final XdmClient client;

    public XdmDimensionalInspectingService(XdmClient client) {
        this.client = client;
    }

    public DimensionalInspectingDto create(DimensionalInspectingDto dto) {
        DimensionalInspectingCreateDTO xdm = new DimensionalInspectingCreateDTO();
        if (dto.getIqcWarehousingId() != null) {
            xdm.setIqcWarehousing(new ObjectReferenceParamDTO("Warehousing", String.valueOf(dto.getIqcWarehousingId())));
        }
        DimensionalInspectingViewDTO view = client.create(ENTITY, xdm, DimensionalInspectingViewDTO.class);
        return toDto(view);
    }

    public DimensionalInspectingDto getById(Long id) {
        DimensionalInspectingViewDTO view = client.get(ENTITY, String.valueOf(id), DimensionalInspectingViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<DimensionalInspectingDto> findAll() {
        return client.findAll(ENTITY, DimensionalInspectingViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public DimensionalInspectingDto update(Long id, DimensionalInspectingDto dto) {
        DimensionalInspectingViewDTO existing = client.get(ENTITY, String.valueOf(id), DimensionalInspectingViewDTO.class);
        if (existing == null) return null;
        DimensionalInspectingUpdateDTO xdm = new DimensionalInspectingUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        if (dto.getIqcWarehousingId() != null) {
            xdm.setIqcWarehousing(new ObjectReferenceParamDTO("Warehousing", String.valueOf(dto.getIqcWarehousingId())));
        }
        DimensionalInspectingViewDTO view = client.update(ENTITY, xdm, DimensionalInspectingViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private DimensionalInspectingDto toDto(DimensionalInspectingViewDTO v) {
        DimensionalInspectingDto dto = new DimensionalInspectingDto();
        dto.setId(parseLong(v.getId()));
        if (v.getIqcWarehousing() != null) {
            dto.setIqcWarehousingId(parseLong(v.getIqcWarehousing().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
