package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.PartDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmPartService {

    private static final String ENTITY = "Part";
    private final XdmClient client;

    public XdmPartService(XdmClient client) {
        this.client = client;
    }

    public PartDto create(PartDto dto) {
        PartCreateDTO xdm = new PartCreateDTO();
        xdm.setPartCode(dto.getPartCode());
        xdm.setPartName(dto.getPartName());
        xdm.setSpecModel(dto.getSpecModel());
        xdm.setSupplier(dto.getSupplier());
        xdm.setStockQuantity(dto.getStockQuantity());
        if (dto.getUsedEquipmentId() != null) {
            xdm.setUsedEquipment(new ObjectReferenceParamDTO("Equitment", String.valueOf(dto.getUsedEquipmentId())));
        }
        PartViewDTO view = client.create(ENTITY, xdm, PartViewDTO.class);
        return toDto(view);
    }

    public PartDto getById(Long id) {
        PartViewDTO view = client.get(ENTITY, String.valueOf(id), PartViewDTO.class);
        return view != null ? toDto(view) : null;
    }

    public List<PartDto> findAll() {
        return client.findAll(ENTITY, PartViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<PartDto> search(String q) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("partCode", "like", "%" + q + "%")
        ));
        return client.find(ENTITY, query, 1, 10000, PartViewDTO.class).stream().map(this::toDto).collect(Collectors.toList());
    }

    public PartDto update(Long id, PartDto dto) {
        PartViewDTO existing = client.get(ENTITY, String.valueOf(id), PartViewDTO.class);
        if (existing == null) return null;
        PartUpdateDTO xdm = new PartUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        xdm.setPartCode(dto.getPartCode());
        xdm.setPartName(dto.getPartName());
        xdm.setSpecModel(dto.getSpecModel());
        xdm.setSupplier(dto.getSupplier());
        xdm.setStockQuantity(dto.getStockQuantity());
        if (dto.getUsedEquipmentId() != null) {
            xdm.setUsedEquipment(new ObjectReferenceParamDTO("Equitment", String.valueOf(dto.getUsedEquipmentId())));
        }
        PartViewDTO view = client.update(ENTITY, xdm, PartViewDTO.class);
        return toDto(view);
    }

    public boolean delete(Long id) {
        return client.delete(ENTITY, String.valueOf(id), "system") > 0;
    }

    private PartDto toDto(PartViewDTO v) {
        PartDto dto = new PartDto();
        dto.setId(parseLong(v.getId()));
        dto.setPartCode(v.getPartCode());
        dto.setPartName(v.getPartName());
        dto.setSpecModel(v.getSpecModel());
        dto.setSupplier(v.getSupplier());
        dto.setStockQuantity(v.getStockQuantity());
        if (v.getUsedEquipment() != null) {
            dto.setUsedEquipmentId(parseLong(v.getUsedEquipment().getId()));
        }
        dto.setCreateTime(v.getCreateTime());
        dto.setLastUpdateTime(v.getLastUpdateTime());
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}
