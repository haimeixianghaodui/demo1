package com.haimeixianghao.demo1.xdm.service;

import com.haimeixianghao.demo1.dto.DeviceCreateDto;
import com.haimeixianghao.demo1.dto.DeviceDto;
import com.haimeixianghao.demo1.dto.DeviceUpdateDto;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class XdmEquitmentService {

    private static final String ENTITY = "Equitment";
    private final XdmClient client;

    public XdmEquitmentService(XdmClient client) {
        this.client = client;
    }

    public DeviceDto create(DeviceCreateDto dto) {
        EquitmentCreateDTO xdm = new EquitmentCreateDTO();
        xdm.setDeviceCode(dto.getDeviceCode());
        xdm.setDeviceName(dto.getDeviceName());
        xdm.setManufacturer(dto.getManufacturer());
        xdm.setBrand(dto.getBrand());
        xdm.setModel(dto.getModel());
        xdm.setSupplier(dto.getSupplier());
        xdm.setProductionDate(dto.getProductionDate());
        xdm.setServiceLife(dto.getServiceLife());
        xdm.setDepreciationMethod(dto.getDepreciationMethod());
        xdm.setLocation(dto.getLocation());
        xdm.setTechnicalParams(dto.getTechnicalParams());
        xdm.setSparePartsInfo(dto.getSparePartsInfo());
        EquitmentViewDTO view = client.create(ENTITY, xdm, EquitmentViewDTO.class);
        return toDeviceDto(view);
    }

    public DeviceDto getById(Long id) {
        EquitmentViewDTO view = client.get(ENTITY, String.valueOf(id), EquitmentViewDTO.class);
        return view != null ? toDeviceDto(view) : null;
    }

    public List<DeviceDto> findAll() {
        List<EquitmentViewDTO> list = client.findAll(ENTITY, EquitmentViewDTO.class);
        return list.stream().map(this::toDeviceDto).collect(Collectors.toList());
    }

    public List<DeviceDto> searchByCodeOrName(String q) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("deviceCode", "like", "%" + q + "%")
        ));
        List<EquitmentViewDTO> list = client.find(ENTITY, query, 1, 10000, EquitmentViewDTO.class);
        return list.stream().map(this::toDeviceDto).collect(Collectors.toList());
    }

    public DeviceDto update(Long id, DeviceUpdateDto dto) {
        EquitmentViewDTO existing = client.get(ENTITY, String.valueOf(id), EquitmentViewDTO.class);
        if (existing == null) return null;
        EquitmentUpdateDTO xdm = new EquitmentUpdateDTO();
        xdm.setId(existing.getId());
        xdm.setRdmVersion(existing.getRdmVersion());
        xdm.setDeviceCode(dto.getDeviceCode());
        xdm.setDeviceName(dto.getDeviceName());
        xdm.setManufacturer(dto.getManufacturer());
        xdm.setBrand(dto.getBrand());
        xdm.setModel(dto.getModel());
        xdm.setSupplier(dto.getSupplier());
        xdm.setProductionDate(dto.getProductionDate());
        xdm.setServiceLife(dto.getServiceLife());
        xdm.setDepreciationMethod(dto.getDepreciationMethod());
        xdm.setLocation(dto.getLocation());
        xdm.setTechnicalParams(dto.getTechnicalParams());
        xdm.setSparePartsInfo(dto.getSparePartsInfo());
        EquitmentViewDTO view = client.update(ENTITY, xdm, EquitmentViewDTO.class);
        return toDeviceDto(view);
    }

    public boolean delete(Long id) {
        int result = client.delete(ENTITY, String.valueOf(id), "system");
        return result > 0;
    }

    private DeviceDto toDeviceDto(EquitmentViewDTO v) {
        DeviceDto dto = new DeviceDto();
        dto.setId(parseLong(v.getId()));
        dto.setDeviceCode(v.getDeviceCode());
        dto.setDeviceName(v.getDeviceName());
        dto.setManufacturer(v.getManufacturer());
        dto.setBrand(v.getBrand());
        dto.setModel(v.getModel());
        dto.setSupplier(v.getSupplier());
        dto.setProductionDate(v.getProductionDate());
        dto.setServiceLife(v.getServiceLife());
        dto.setDepreciationMethod(v.getDepreciationMethod());
        dto.setLocation(v.getLocation());
        dto.setStatus(v.getStatus());
        dto.setType(v.getType());
        dto.setImage(v.getImage());
        dto.setTechnicalParams(v.getTechnicalParams());
        dto.setSparePartsInfo(v.getSparePartsInfo());
        dto.setCreateTime(parseDateTime(v.getCreateTime()));
        dto.setUpdateTime(parseDateTime(v.getLastUpdateTime()));
        return dto;
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }

    private LocalDateTime parseDateTime(String s) {
        try { return s != null ? LocalDateTime.parse(s) : null; } catch (Exception e) { return null; }
    }
}