package com.haimeixianghao.demo1.dto;

public class BlankManufacturingDto {
    private Long id;
    private Long machiningId;
    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMachiningId() { return machiningId; }
    public void setMachiningId(Long machiningId) { this.machiningId = machiningId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

