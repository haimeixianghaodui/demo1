package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.MachiningDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmMachiningService {

    private static final String ENTITY = "Machining";
    private final XdmClient client;

    public XdmMachiningService(XdmClient client) {
        this.client = client;
    }

    public MachiningDto create(MachiningDto dto) {
        MachiningCreateDTO xdm = new MachiningCreateDTO();
        if (dto.getMachiningShaftMachiningId() != null) {
            xdm.setMachiningShaftMachining(new ObjectReferenceParamDTO("ShaftMachining", String.valueOf(dto.getMachiningShaftMachiningId())));
        }
        MachiningViewDTO view = client.create(ENTITY, xdm, MachiningViewDTO.class);
        return toDto(view);
    }

    public MachiningDto getById(Long id) {
        MachiningViewDTO view = client.get(ENTITY, String.valueOf(id), MachiningViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<MachiningDto> findAll() {
        return client.findAll(ENTITY, MachiningViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public MachiningDto update(Long id, MachiningDto dto) {
        MachiningViewDTO existing = client.get(ENTITY, String.valueOf(id), MachiningViewDTO.class);
        if (existing == null) return null;
        MachiningUpdateDTO xdm = new MachiningUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        if (dto.getMachiningShaftMachiningId() != null) {
            xdm.setMachiningShaftMachining(new ObjectReferenceParamDTO("ShaftMachining", String.valueOf(dto.getMachiningShaftMachiningId())));
        }
        MachiningViewDTO view = client.update(ENTITY, xdm, MachiningViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private MachiningDto toDto(MachiningViewDTO v) {
        MachiningDto dto = new MachiningDto();
        dto.setId(parseLong(v.getId()));
        if (v.getMachiningShaftMachining() != null) {
            dto.setMachiningShaftMachiningId(parseLong(v.getMachiningShaftMachining().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
