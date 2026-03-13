package com.haimeixianghao.demo1.xdm.dto;

public class BlankmanuFacturingUpdateDTO {
    private String id;
    private String rdmVersion;
    private ObjectReferenceParamDTO machining;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getMachining() { return machining; }
    public void setMachining(ObjectReferenceParamDTO machining) { this.machining = machining; }
}
