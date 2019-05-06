package cn.jiayao.myjwt.modular.tools;

import java.util.List;

public class Page<T> {

    private List<T> dataList;

    private int pageSize;//页大小

    private int pageNum;//当前页

    private int total;//总条数

    private int offset;//查询起始条数

    private transient String sort;//排序方式

    private transient String sortDesc;//排序字段


    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }


    public Page(int pageNum, int pageSize, String sort, String sortDesc) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.sort = sort;
        this.sortDesc = sortDesc;
        initOffset();
    }


    public void initOffset() {
        this.offset = pageNum * pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(String sortDesc) {
        this.sortDesc = sortDesc;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        initOffset();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        initOffset();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
