package com.haimeixianghao.demo1.xdm.dto;

public class QueryCondition {
    private String conditionName;
    private String operator;
    private String conditionValue;

    public QueryCondition() {}

    public QueryCondition(String conditionName, String operator, String conditionValue) {
        this.conditionName = conditionName;
        this.operator = operator;
        this.conditionValue = conditionValue;
    }

    public String getConditionName() { return conditionName; }
    public void setConditionName(String conditionName) { this.conditionName = conditionName; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getConditionValue() { return conditionValue; }
    public void setConditionValue(String conditionValue) { this.conditionValue = conditionValue; }
}
