package com.haimeixianghao.demo1.xdm.dto;

public class WorkingProcedureCreateDTO {
    private String procedureCode;
    private String procedureName;
    private String operator;
    private String productionStep;
    private ObjectReferenceParamDTO plan2Part;

    public String getProcedureCode() { return procedureCode; }
    public void setProcedureCode(String procedureCode) { this.procedureCode = procedureCode; }
    public String getProcedureName() { return procedureName; }
    public void setProcedureName(String procedureName) { this.procedureName = procedureName; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getProductionStep() { return productionStep; }
    public void setProductionStep(String productionStep) { this.productionStep = productionStep; }
    public ObjectReferenceParamDTO getPlan2Part() { return plan2Part; }
    public void setPlan2Part(ObjectReferenceParamDTO plan2Part) { this.plan2Part = plan2Part; }
}
