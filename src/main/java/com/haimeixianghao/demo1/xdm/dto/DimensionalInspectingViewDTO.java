package com.haimeixianghao.demo1.xdm.dto;

public class DimensionalInspectingViewDTO {
    private String id;
    private String className;
    private String rdmVersion;
    private ObjectReferenceParamDTO iqcWarehousing;
    private String createTime;
    private String lastUpdateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public ObjectReferenceParamDTO getIqcWarehousing() { return iqcWarehousing; }
    public void setIqcWarehousing(ObjectReferenceParamDTO iqcWarehousing) { this.iqcWarehousing = iqcWarehousing; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}
