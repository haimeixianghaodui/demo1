package com.haimeixianghao.demo1.xdm.dto;

public class PartCreateDTO {
    private String partCode;
    private String partName;
    private String specModel;
    private String supplier;
    private Integer stockQuantity;
    private ObjectReferenceParamDTO usedEquipment;

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
    public ObjectReferenceParamDTO getUsedEquipment() { return usedEquipment; }
    public void setUsedEquipment(ObjectReferenceParamDTO usedEquipment) { this.usedEquipment = usedEquipment; }
}
