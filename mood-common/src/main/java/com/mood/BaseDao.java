package com.mood;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-10-31 下午2:41
 */
public interface BaseDao<T, ID extends Serializable> {

    /**
     * 插入
     *
     * @param t
     * @return
     */
    T insert(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    T update(T t);

    /**
     * 删除详情
     *
     * @param id
     */
    Boolean deleteById(ID id);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    T selectById(ID id);

    /**
     * 获取列表
     *
     * @param t
     * @return
     */
    List<T> selectList(T t);

    /**
     * 分页查询
     *
     * @param t
     * @return
     */
    Pager<T> selectPager(PagerDTO t);

}
