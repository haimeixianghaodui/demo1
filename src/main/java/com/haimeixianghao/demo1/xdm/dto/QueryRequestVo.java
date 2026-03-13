package com.haimeixianghao.demo1.xdm.dto;

import java.util.List;

public class QueryRequestVo {
    private List<QueryCondition> conditions;
    private boolean decrypt = true;

    public QueryRequestVo() {}

    public QueryRequestVo(List<QueryCondition> conditions) {
        this.conditions = conditions;
    }

    public List<QueryCondition> getConditions() { return conditions; }
    public void setConditions(List<QueryCondition> conditions) { this.conditions = conditions; }
    public boolean isDecrypt() { return decrypt; }
    public void setDecrypt(boolean decrypt) { this.decrypt = decrypt; }
}
