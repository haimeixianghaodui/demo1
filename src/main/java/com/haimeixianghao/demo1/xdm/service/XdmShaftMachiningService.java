package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.ShaftMachiningDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmShaftMachiningService {

    private static final String ENTITY = "ShaftMachining";
    private final XdmClient client;

    public XdmShaftMachiningService(XdmClient client) {
        this.client = client;
    }

    public ShaftMachiningDto create(ShaftMachiningDto dto) {
        ShaftMachiningCreateDTO xdm = new ShaftMachiningCreateDTO();
        if (dto.getFqcDimensionalInspectingId() != null) {
            xdm.setFqcDimensionalInspecting(new ObjectReferenceParamDTO("Dimensional_inspecting", String.valueOf(dto.getFqcDimensionalInspectingId())));
        }
        ShaftMachiningViewDTO view = client.create(ENTITY, xdm, ShaftMachiningViewDTO.class);
        return toDto(view);
    }

    public ShaftMachiningDto getById(Long id) {
        ShaftMachiningViewDTO view = client.get(ENTITY, String.valueOf(id), ShaftMachiningViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<ShaftMachiningDto> findAll() {
        return client.findAll(ENTITY, ShaftMachiningViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public ShaftMachiningDto update(Long id, ShaftMachiningDto dto) {
        ShaftMachiningViewDTO existing = client.get(ENTITY, String.valueOf(id), ShaftMachiningViewDTO.class);
        if (existing == null) return null;
        ShaftMachiningUpdateDTO xdm = new ShaftMachiningUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        if (dto.getFqcDimensionalInspectingId() != null) {
            xdm.setFqcDimensionalInspecting(new ObjectReferenceParamDTO("Dimensional_inspecting", String.valueOf(dto.getFqcDimensionalInspectingId())));
        }
        ShaftMachiningViewDTO view = client.update(ENTITY, xdm, ShaftMachiningViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private ShaftMachiningDto toDto(ShaftMachiningViewDTO v) {
        ShaftMachiningDto dto = new ShaftMachiningDto();
        dto.setId(parseLong(v.getId()));
        if (v.getFqcDimensionalInspecting() != null) {
            dto.setFqcDimensionalInspectingId(parseLong(v.getFqcDimensionalInspecting().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
