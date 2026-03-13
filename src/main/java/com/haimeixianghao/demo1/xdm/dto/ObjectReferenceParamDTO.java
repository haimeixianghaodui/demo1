package com.haimeixianghao.demo1.xdm.dto;

public class ObjectReferenceParamDTO {
    private String clazz;
    private String id;

    public ObjectReferenceParamDTO() {}

    public ObjectReferenceParamDTO(String clazz, String id) {
        this.clazz = clazz;
        this.id = id;
    }

    public String getClazz() { return clazz; }
    public void setClazz(String clazz) { this.clazz = clazz; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
