package com.haimeixianghao.demo1.xdm.dto;

import java.util.List;

public class XdmPageResponse<T> {
    private int result;
    private List<T> data;
    private int totalCount;
    private int pageSize;
    private int curPage;

    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }
    public List<T> getData() { return data; }
    public void setData(List<T> data) { this.data = data; }
    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }
    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }
    public int getCurPage() { return curPage; }
    public void setCurPage(int curPage) { this.curPage = curPage; }
}
