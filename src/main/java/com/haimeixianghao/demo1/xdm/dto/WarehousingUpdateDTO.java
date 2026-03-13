package com.haimeixianghao.demo1.xdm.dto;

public class WarehousingUpdateDTO {
    private String id;
    private String rdmVersion;
    private ObjectReferenceParamDTO inPart;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getInPart() { return inPart; }
    public void setInPart(ObjectReferenceParamDTO inPart) { this.inPart = inPart; }
}
