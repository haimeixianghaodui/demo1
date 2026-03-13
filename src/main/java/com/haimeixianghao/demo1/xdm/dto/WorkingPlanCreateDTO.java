package com.haimeixianghao.demo1.xdm.dto;

public class WorkingPlanCreateDTO {
    private String planCode;
    private String planName;
    private String version;
    private String equipmentUsage;
    private String operator;
    private ObjectReferenceParamDTO plan1Part;

    public String getPlanCode() { return planCode; }
    public void setPlanCode(String planCode) { this.planCode = planCode; }
    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getEquipmentUsage() { return equipmentUsage; }
    public void setEquipmentUsage(String equipmentUsage) { this.equipmentUsage = equipmentUsage; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public ObjectReferenceParamDTO getPlan1Part() { return plan1Part; }
    public void setPlan1Part(ObjectReferenceParamDTO plan1Part) { this.plan1Part = plan1Part; }
}
