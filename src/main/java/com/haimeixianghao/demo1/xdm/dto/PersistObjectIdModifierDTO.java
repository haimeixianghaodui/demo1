package com.haimeixianghao.demo1.xdm.dto;

public class PersistObjectIdModifierDTO {
    private String id;
    private String modifier;

    public PersistObjectIdModifierDTO() {}

    public PersistObjectIdModifierDTO(String id, String modifier) {
        this.id = id;
        this.modifier = modifier;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getModifier() { return modifier; }
    public void setModifier(String modifier) { this.modifier = modifier; }
}
