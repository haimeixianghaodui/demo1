package com.haimeixianghao.demo1.xdm.dto;

public class DimensionalInspectingUpdateDTO {
    private String id;
    private String rdmVersion;
    private ObjectReferenceParamDTO iqcWarehousing;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getIqcWarehousing() { return iqcWarehousing; }
    public void setIqcWarehousing(ObjectReferenceParamDTO iqcWarehousing) { this.iqcWarehousing = iqcWarehousing; }
}
