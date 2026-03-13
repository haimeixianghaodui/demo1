package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.BlankManufacturingDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmBlankmanuFacturingService {

    private static final String ENTITY = "BlankmanuFacturing";
    private final XdmClient client;

    public XdmBlankmanuFacturingService(XdmClient client) {
        this.client = client;
    }

    public BlankManufacturingDto create(BlankManufacturingDto dto) {
        BlankmanuFacturingCreateDTO xdm = new BlankmanuFacturingCreateDTO();
        if (dto.getMachiningId() != null) {
            xdm.setMachining(new ObjectReferenceParamDTO("Machining", String.valueOf(dto.getMachiningId())));
        }
        BlankmanuFacturingViewDTO view = client.create(ENTITY, xdm, BlankmanuFacturingViewDTO.class);
        return toDto(view);
    }

    public BlankManufacturingDto getById(Long id) {
        BlankmanuFacturingViewDTO view = client.get(ENTITY, String.valueOf(id), BlankmanuFacturingViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<BlankManufacturingDto> findAll() {
        return client.findAll(ENTITY, BlankmanuFacturingViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public BlankManufacturingDto update(Long id, BlankManufacturingDto dto) {
        BlankmanuFacturingViewDTO existing = client.get(ENTITY, String.valueOf(id), BlankmanuFacturingViewDTO.class);
        if (existing == null) return null;
        BlankmanuFacturingUpdateDTO xdm = new BlankmanuFacturingUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        if (dto.getMachiningId() != null) {
            xdm.setMachining(new ObjectReferenceParamDTO("Machining", String.valueOf(dto.getMachiningId())));
        }
        BlankmanuFacturingViewDTO view = client.update(ENTITY, xdm, BlankmanuFacturingViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private BlankManufacturingDto toDto(BlankmanuFacturingViewDTO v) {
        BlankManufacturingDto dto = new BlankManufacturingDto();
        dto.setId(parseLong(v.getId()));
        if (v.getMachining() != null) {
            dto.setMachiningId(parseLong(v.getMachining().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
