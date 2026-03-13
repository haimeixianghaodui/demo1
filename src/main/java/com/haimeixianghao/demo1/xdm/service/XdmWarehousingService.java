package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.WarehousingDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmWarehousingService {

    private static final String ENTITY = "Warehousing";
    private final XdmClient client;

    public XdmWarehousingService(XdmClient client) {
        this.client = client;
    }

    public WarehousingDto create(WarehousingDto dto) {
        WarehousingCreateDTO xdm = new WarehousingCreateDTO();
        if (dto.getInPartId() != null) {
            xdm.setInPart(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getInPartId())));
        }
        WarehousingViewDTO view = client.create(ENTITY, xdm, WarehousingViewDTO.class);
        return toDto(view);
    }

    public WarehousingDto getById(Long id) {
        WarehousingViewDTO view = client.get(ENTITY, String.valueOf(id), WarehousingViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<WarehousingDto> findAll() {
        return client.findAll(ENTITY, WarehousingViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public WarehousingDto update(Long id, WarehousingDto dto) {
        WarehousingViewDTO existing = client.get(ENTITY, String.valueOf(id), WarehousingViewDTO.class);
        if (existing == null) return null;
        WarehousingUpdateDTO xdm = new WarehousingUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        if (dto.getInPartId() != null) {
            xdm.setInPart(new ObjectReferenceParamDTO("Part", String.valueOf(dto.getInPartId())));
        }
        WarehousingViewDTO view = client.update(ENTITY, xdm, WarehousingViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private WarehousingDto toDto(WarehousingViewDTO v) {
        WarehousingDto dto = new WarehousingDto();
        dto.setId(parseLong(v.getId()));
        if (v.getInPart() != null) {
            dto.setInPartId(parseLong(v.getInPart().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
