package com.haimeixianghao.demo1.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class DeviceUpdateDto {
    @NotBlank
    @Size(max = 255)
    private String deviceCode;

    @NotBlank
    @Size(max = 255)
    private String deviceName;

    @Size(max = 255)
    private String manufacturer;

    @Size(max = 255)
    private String brand;

    @Size(max = 255)
    private String model;

    @Size(max = 255)
    private String supplier;

    @PastOrPresent
    private LocalDate productionDate;

    @Min(0)
    private Integer serviceLife;

    @Size(max = 255)
    private String depreciationMethod;

    @Size(max = 255)
    private String location;

    @Size(max = 2000)
    private String technicalParams;

    @Size(max = 2000)
    private String sparePartsInfo;

    // getters and setters
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
}

