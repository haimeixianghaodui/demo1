package com.haimeixianghao.demo1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PartDto {
    private Long id;

    @NotBlank @Size(max = 200)
    private String partCode;

    @NotBlank @Size(max = 200)
    private String partName;

    @Size(max = 200)
    private String specModel;

    @Size(max = 200)
    private String supplier;

    private Integer stockQuantity;

    private Long usedEquipmentId;

    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPartCode() { return partCode; }
    public void setPartCode(String partCode) { this.partCode = partCode; }
    public String getPartName() { return partName; }
    public void setPartName(String partName) { this.partName = partName; }
    public String getSpecModel() { return specModel; }
    public void setSpecModel(String specModel) { this.specModel = specModel; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public Long getUsedEquipmentId() { return usedEquipmentId; }
    public void setUsedEquipmentId(Long usedEquipmentId) { this.usedEquipmentId = usedEquipmentId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

