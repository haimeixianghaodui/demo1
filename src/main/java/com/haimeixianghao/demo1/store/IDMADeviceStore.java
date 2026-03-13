package com.haimeixianghao.demo1.store;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.xdm.XdmClient;
import com.haimeixianghao.demo1.xdm.dto.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(prefix = "idma", name = "enabled", havingValue = "true")
public class IDMADeviceStore implements DeviceStore {

    private static final String ENTITY = "Equitment";
    private final XdmClient client;

    public IDMADeviceStore(XdmClient client) {
        this.client = client;
    }

    @Override
    public Device save(Device device) {
        if (device.getId() != null) {
            EquitmentViewDTO existing = client.get(ENTITY, String.valueOf(device.getId()), EquitmentViewDTO.class);
            if (existing != null) {
                EquitmentUpdateDTO dto = new EquitmentUpdateDTO();
                dto.setId(existing.getId());
                dto.setRdmVersion(existing.getRdmVersion());
                copyToUpdate(device, dto);
                EquitmentViewDTO view = client.update(ENTITY, dto, EquitmentViewDTO.class);
                return toDevice(view);
            }
        }
        EquitmentCreateDTO dto = new EquitmentCreateDTO();
        copyToCreate(device, dto);
        EquitmentViewDTO view = client.create(ENTITY, dto, EquitmentViewDTO.class);
        return toDevice(view);
    }

    @Override
    public Optional<Device> findById(Long id) {
        try {
            EquitmentViewDTO view = client.get(ENTITY, String.valueOf(id), EquitmentViewDTO.class);
            return view != null ? Optional.of(toDevice(view)) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Device> findAll() {
        return client.findAll(ENTITY, EquitmentViewDTO.class).stream()
                .map(this::toDevice).collect(Collectors.toList());
    }

    @Override
    public List<Device> findByDeviceCodeContainingIgnoreCase(String deviceCode) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("deviceCode", "like", "%" + deviceCode + "%")));
        return client.find(ENTITY, query, 1, 10000, EquitmentViewDTO.class).stream()
                .map(this::toDevice).collect(Collectors.toList());
    }

    @Override
    public List<Device> findByDeviceNameContainingIgnoreCase(String deviceName) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("deviceName", "like", "%" + deviceName + "%")));
        return client.find(ENTITY, query, 1, 10000, EquitmentViewDTO.class).stream()
                .map(this::toDevice).collect(Collectors.toList());
    }

    @Override
    public List<Device> findByManufacturerContainingIgnoreCase(String manufacturer) {
        QueryRequestVo query = new QueryRequestVo(List.of(
                new QueryCondition("manufacturer", "like", "%" + manufacturer + "%")));
        return client.find(ENTITY, query, 1, 10000, EquitmentViewDTO.class).stream()
                .map(this::toDevice).collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public void deleteById(Long id) {
        client.delete(ENTITY, String.valueOf(id), "system");
    }

    private Device toDevice(EquitmentViewDTO v) {
        Device d = new Device();
        d.setId(parseLong(v.getId()));
        d.setDeviceCode(v.getDeviceCode());
        d.setDeviceName(v.getDeviceName());
        d.setManufacturer(v.getManufacturer());
        d.setBrand(v.getBrand());
        d.setModel(v.getModel());
        d.setSupplier(v.getSupplier());
        d.setProductionDate(v.getProductionDate());
        d.setServiceLife(v.getServiceLife());
        d.setDepreciationMethod(v.getDepreciationMethod());
        d.setLocation(v.getLocation());
        d.setStatus(v.getStatus());
        d.setType(v.getType());
        d.setImage(v.getImage());
        d.setTechnicalParams(v.getTechnicalParams());
        d.setSparePartsInfo(v.getSparePartsInfo());
        try { d.setCreateTime(v.getCreateTime() != null ? LocalDateTime.parse(v.getCreateTime()) : null); } catch (Exception ignored) {}
        try { d.setUpdateTime(v.getLastUpdateTime() != null ? LocalDateTime.parse(v.getLastUpdateTime()) : null); } catch (Exception ignored) {}
        return d;
    }

    private void copyToCreate(Device d, EquitmentCreateDTO dto) {
        dto.setDeviceCode(d.getDeviceCode());
        dto.setDeviceName(d.getDeviceName());
        dto.setManufacturer(d.getManufacturer());
        dto.setBrand(d.getBrand());
        dto.setModel(d.getModel());
        dto.setSupplier(d.getSupplier());
        dto.setProductionDate(d.getProductionDate());
        dto.setServiceLife(d.getServiceLife());
        dto.setDepreciationMethod(d.getDepreciationMethod());
        dto.setLocation(d.getLocation());
        dto.setTechnicalParams(d.getTechnicalParams());
        dto.setSparePartsInfo(d.getSparePartsInfo());
    }

    private void copyToUpdate(Device d, EquitmentUpdateDTO dto) {
        dto.setDeviceCode(d.getDeviceCode());
        dto.setDeviceName(d.getDeviceName());
        dto.setManufacturer(d.getManufacturer());
        dto.setBrand(d.getBrand());
        dto.setModel(d.getModel());
        dto.setSupplier(d.getSupplier());
        dto.setProductionDate(d.getProductionDate());
        dto.setServiceLife(d.getServiceLife());
        dto.setDepreciationMethod(d.getDepreciationMethod());
        dto.setLocation(d.getLocation());
        dto.setTechnicalParams(d.getTechnicalParams());
        dto.setSparePartsInfo(d.getSparePartsInfo());
    }

    private Long parseLong(String s) {
        try { return s != null ? Long.parseLong(s) : null; } catch (NumberFormatException e) { return null; }
    }
}

