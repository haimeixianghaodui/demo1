package com.haimeixianghao.demo1.xdm.dto;

public class WorkingProcedureViewDTO {
    private String id;
    private String className;
    private String rdmVersion;
    private String procedureCode;
    private String procedureName;
    private String startTime;
    private String endTime;
    private String operator;
    private String productionStep;
    private ObjectReferenceParamDTO plan2Part;
    private String createTime;
    private String lastUpdateTime;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getRdmVersion() { return rdmVersion; }
    public void setRdmVersion(String rdmVersion) { this.rdmVersion = rdmVersion; }
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
    public ObjectReferenceParamDTO getPlan2Part() { return plan2Part; }
    public void setPlan2Part(ObjectReferenceParamDTO plan2Part) { this.plan2Part = plan2Part; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}
