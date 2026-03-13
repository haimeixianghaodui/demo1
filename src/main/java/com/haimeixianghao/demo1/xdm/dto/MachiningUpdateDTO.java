package com.haimeixianghao.demo1.xdm.dto;

public class MachiningUpdateDTO {
    private String id;
    private String rdmVersion;
    private ObjectReferenceParamDTO machiningShaftMachining;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getMachiningShaftMachining() { return machiningShaftMachining; }
    public void setMachiningShaftMachining(ObjectReferenceParamDTO machiningShaftMachining) { this.machiningShaftMachining = machiningShaftMachining; }
}
