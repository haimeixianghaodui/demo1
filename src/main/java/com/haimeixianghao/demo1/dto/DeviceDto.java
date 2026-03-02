package com.haimeixianghao.demo1.dto;

import java.time.LocalDate;

public class DeviceDto {
    private Long id;
    private String deviceCode;
    private String deviceName;
    private String manufacturer;
    private String brand;
    private String model;
    private String supplier;
    private LocalDate productionDate;
    private Integer serviceLife;
    private String depreciationMethod;
    private String location;
    private String technicalParams;
    private String sparePartsInfo;
    private LocalDate createTime;
    private LocalDate updateTime;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDeviceCode() { return deviceCode; }
    public void setDeviceCode(String deviceCode) { this.deviceCode = deviceCode; }
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public LocalDate getProductionDate() { return productionDate; }
    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }
    public Integer getServiceLife() { return serviceLife; }
    public void setServiceLife(Integer serviceLife) { this.serviceLife = serviceLife; }
    public String getDepreciationMethod() { return depreciationMethod; }
    public void setDepreciationMethod(String depreciationMethod) { this.depreciationMethod = depreciationMethod; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getTechnicalParams() { return technicalParams; }
    public void setTechnicalParams(String technicalParams) { this.technicalParams = technicalParams; }
    public String getSparePartsInfo() { return sparePartsInfo; }
    public void setSparePartsInfo(String sparePartsInfo) { this.sparePartsInfo = sparePartsInfo; }
    public LocalDate getCreateTime() { return createTime; }
    public void setCreateTime(LocalDate createTime) { this.createTime = createTime; }
    public LocalDate getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDate updateTime) { this.updateTime = updateTime; }
}

