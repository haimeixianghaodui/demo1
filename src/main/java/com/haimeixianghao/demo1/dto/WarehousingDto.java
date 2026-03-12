package com.haimeixianghao.demo1.dto;

public class WarehousingDto {
    private Long id;
    private Long inPartId;
    private String createTime;
    private String lastUpdateTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getInPartId() { return inPartId; }
    public void setInPartId(Long inPartId) { this.inPartId = inPartId; }
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }
    public String getLastUpdateTime() { return lastUpdateTime; }
    public void setLastUpdateTime(String lastUpdateTime) { this.lastUpdateTime = lastUpdateTime; }
}

