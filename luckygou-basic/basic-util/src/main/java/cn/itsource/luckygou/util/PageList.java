package cn.itsource.luckygou.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询的工具
 * @param <T>
 */
public class PageList<T> {
    private Integer total = 0;
    private List<T> rows = new ArrayList<>();

    public PageList() {
    }

    public PageList(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
