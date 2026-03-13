package com.haimeixianghao.demo1.xdm.dto;

public class WarehousingViewDTO {
    private String id;
    private String className;
    private String rdmVersion;
    private ObjectReferenceParamDTO inPart;
    private String createTime;
    private String lastUpdateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getInPart() { return inPart; }
    public void setInPart(ObjectReferenceParamDTO inPart) { this.inPart = inPart; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}
