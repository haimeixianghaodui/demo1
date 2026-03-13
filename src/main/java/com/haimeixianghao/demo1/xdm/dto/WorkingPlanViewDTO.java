package com.haimeixianghao.demo1.xdm.dto;

public class WorkingPlanViewDTO {
    private String id;
    private String className;
    private String rdmVersion;
    private String planCode;
    private String planName;
    private String version;
    private String operationTime;
    private String equipmentUsage;
    private String operator;
    private ObjectReferenceParamDTO plan1Part;
    private String createTime;
    private String lastUpdateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
    public String getPlanCode() { return planCode; }
    public void setPlanCode(String planCode) { this.planCode = planCode; }
    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getOperationTime() { return operationTime; }
    public void setOperationTime(String operationTime) { this.operationTime = operationTime; }
    public String getEquipmentUsage() { return equipmentUsage; }
    public void setEquipmentUsage(String equipmentUsage) { this.equipmentUsage = equipmentUsage; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public ObjectReferenceParamDTO getPlan1Part() { return plan1Part; }
    public void setPlan1Part(ObjectReferenceParamDTO plan1Part) { this.plan1Part = plan1Part; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}
