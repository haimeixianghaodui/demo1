package com.haimeixianghao.demo1.xdm.dto;

public class PersistObjectIdDecryptDTO {
    private String id;
    private boolean decrypt = true;

    public PersistObjectIdDecryptDTO() {}

    public PersistObjectIdDecryptDTO(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public boolean isDecrypt() { return decrypt; }
    public void setDecrypt(boolean decrypt) { this.decrypt = decrypt; }
}
