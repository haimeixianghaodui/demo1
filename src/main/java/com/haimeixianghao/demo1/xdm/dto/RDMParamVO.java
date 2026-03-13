package com.haimeixianghao.demo1.xdm.dto;

public class RDMParamVO<T> {
    private String applicationId;
    private T params;

    public RDMParamVO() {}

    public RDMParamVO(String applicationId, T params) {
        this.applicationId = applicationId;
        this.params = params;
    }

    public String getApplicationId() { return applicationId; }
    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }
    public T getParams() { return params; }
    public void setParams(T params) { this.params = params; }
}
