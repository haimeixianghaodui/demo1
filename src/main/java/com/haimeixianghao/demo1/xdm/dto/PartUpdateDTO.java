package com.haimeixianghao.demo1.xdm.dto;

public class PartUpdateDTO {
    private String id;
    private String rdmVersion;
    private String partCode;
    private String partName;
    private String specModel;
    private String supplier;
    private Integer stockQuantity;
    private ObjectReferenceParamDTO usedEquipment;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
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
