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
public class PagerDTO<T> implements Serializable {

    /**
     * 页码
     */
    private Long pageIndex;
    /**
     * 每页显示记录数
     */
    private Long pageSize;

    /**
     * 条件传递
     */
    private JSONObject params = new JSONObject();

    /**
     * 条件传递
     */
    private T t;

    /**
     * 排序
     */
    private String orderBy;

    public PagerDTO() {
    }

    public PagerDTO(Long pageIndex, Long pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public PagerDTO(Long pageIndex, Long pageSize, T t) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.t = t;
    }

    public PagerDTO(Long pageIndex, Long pageSize, JSONObject params) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        if (params.size() > 0) {
            this.params = params;
        }
    }

    public PagerDTO(Long pageIndex, Long pageSize, JSONObject params, String orderBy) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        if (params.size() > 0) {
            this.params = params;
        }
        this.orderBy = orderBy;
    }

    public PagerDTO(Long pageIndex, Long pageSize, JSONObject params, T t) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        if (params.size() > 0) {
            this.params = params;
        }
        this.t = t;
    }

    public PagerDTO(Long pageIndex, Long pageSize, String orderBy) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }


}
