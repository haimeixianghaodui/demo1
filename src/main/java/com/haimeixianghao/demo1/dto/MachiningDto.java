package com.haimeixianghao.demo1.dto;

public class MachiningDto {
    private Long id;
    private Long machiningShaftMachiningId;
    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMachiningShaftMachiningId() { return machiningShaftMachiningId; }
    public void setMachiningShaftMachiningId(Long machiningShaftMachiningId) { this.machiningShaftMachiningId = machiningShaftMachiningId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

