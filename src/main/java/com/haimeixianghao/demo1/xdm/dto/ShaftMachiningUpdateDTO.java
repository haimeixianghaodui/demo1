package com.haimeixianghao.demo1.xdm.dto;

public class ShaftMachiningUpdateDTO {
    private String id;
    private String rdmVersion;
    private ObjectReferenceParamDTO fqcDimensionalInspecting;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getFqcDimensionalInspecting() { return fqcDimensionalInspecting; }
    public void setFqcDimensionalInspecting(ObjectReferenceParamDTO fqcDimensionalInspecting) { this.fqcDimensionalInspecting = fqcDimensionalInspecting; }
}
