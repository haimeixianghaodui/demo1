package com.haimeixianghao.demo1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WorkingProcedureDto {
    private Long id;

    @NotBlank @Size(max = 200)
    private String procedureCode;

    @NotBlank @Size(max = 200)
    private String procedureName;

    private String startTime;
    private String endTime;

    @Size(max = 200)
    private String operator;

    @Size(max = 200)
    private String productionStep;

    private Long plan2PartId;

    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProcedureCode() { return procedureCode; }
    public void setProcedureCode(String procedureCode) { this.procedureCode = procedureCode; }
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getProductionStep() { return productionStep; }
    public void setProductionStep(String productionStep) { this.productionStep = productionStep; }
    public Long getPlan2PartId() { return plan2PartId; }
    public void setPlan2PartId(Long plan2PartId) { this.plan2PartId = plan2PartId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

