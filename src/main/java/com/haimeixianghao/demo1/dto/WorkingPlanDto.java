package com.haimeixianghao.demo1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WorkingPlanDto {
    private Long id;

    @NotBlank @Size(max = 200)
    private String planCode;

    @NotBlank @Size(max = 200)
    private String planName;

    @Size(max = 200)
    private String version;

    private String operationTime;

    @Size(max = 200)
    private String equipmentUsage;

    @Size(max = 200)
    private String operator;

    private Long plan1PartId;

    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public Long getPlan1PartId() { return plan1PartId; }
    public void setPlan1PartId(Long plan1PartId) { this.plan1PartId = plan1PartId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

