package com.haimeixianghao.demo1.mapper;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.dto.DeviceCreateDto;
import com.haimeixianghao.demo1.dto.DeviceDto;
import com.haimeixianghao.demo1.dto.DeviceUpdateDto;

import java.time.LocalDate;

public class DeviceMapper {

    public static DeviceDto toDto(Device d) {
        if (d == null) return null;
        DeviceDto dto = new DeviceDto();
        dto.setId(d.getId());
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
        dto.setCreateTime(d.getCreateTime());
        dto.setUpdateTime(d.getUpdateTime());
        return dto;
    }

    public static Device toEntity(DeviceCreateDto dto) {
        if (dto == null) return null;
        Device e = new Device();
        e.setDeviceCode(dto.getDeviceCode());
        e.setDeviceName(dto.getDeviceName());
        e.setManufacturer(dto.getManufacturer());
        e.setBrand(dto.getBrand());
        e.setModel(dto.getModel());
        e.setSupplier(dto.getSupplier());
        e.setProductionDate(dto.getProductionDate());
        e.setServiceLife(dto.getServiceLife());
        e.setDepreciationMethod(dto.getDepreciationMethod());
        e.setLocation(dto.getLocation());
        e.setTechnicalParams(dto.getTechnicalParams());
        e.setSparePartsInfo(dto.getSparePartsInfo());
        // createTime/updateTime handled by service
        e.setCreateTime(LocalDate.now());
        e.setUpdateTime(LocalDate.now());
        return e;
    }

    public static void updateEntity(DeviceUpdateDto dto, Device e) {
        if (dto == null || e == null) return;
        e.setDeviceCode(dto.getDeviceCode());
        e.setDeviceName(dto.getDeviceName());
        e.setManufacturer(dto.getManufacturer());
        e.setBrand(dto.getBrand());
        e.setModel(dto.getModel());
        e.setSupplier(dto.getSupplier());
        e.setProductionDate(dto.getProductionDate());
        e.setServiceLife(dto.getServiceLife());
        e.setDepreciationMethod(dto.getDepreciationMethod());
        e.setLocation(dto.getLocation());
        e.setTechnicalParams(dto.getTechnicalParams());
        e.setSparePartsInfo(dto.getSparePartsInfo());
        e.setUpdateTime(LocalDate.now());
    }
}

