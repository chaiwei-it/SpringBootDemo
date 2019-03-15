package com.mood;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-12-28 下午2:38
 */
@Data
public class Pager<T> implements Serializable {

    /**
     * 列表数据
     */
    private List<T> content;

    /**
     * 页码
     */
    private Long pageIndex;
    /**
     * 每页显示记录数
     */
    private Long pageSize;
    /**
     * 总页数
     */
    private Long maxPages;
    /**
     * 总记录数
     */
    private Long total;


    public Pager() {
    }

    public Pager(Long pageIndex, Long pageSize, Long total, List<T> content) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.maxPages = total == 0 ? 1 : (total + pageSize - 1) / pageSize;
        if (content != null) {
            this.content = content;
        }
    }


}
