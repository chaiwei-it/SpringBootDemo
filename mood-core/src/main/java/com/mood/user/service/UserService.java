package com.mood.user.service;

import com.mood.Pager;
import com.mood.PagerDTO;
import com.mood.user.dto.UserDTO;
import com.mood.user.vo.UserVO;

import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2019-03-14 11:00 AM
 */
public interface UserService {
    /**
     * 插入
     *
     * @param userDTO
     * @return
     */
    UserVO insert(UserDTO userDTO);

    /**
     * 修改
     *
     * @param userDTO
     * @return
     */
    UserVO update(UserDTO userDTO);

    /**
     * 删除详情
     *
     * @param id
     */
    Boolean deleteById(String id);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    UserVO selectById(String id);

    /**
     * 获取列表
     *
     * @param userDTO
     * @return
     */
    List<UserVO> selectList(UserDTO userDTO);

    /**
     * 获取分页
     *
     * @param pagerDTO
     * @return
     */
    Pager<UserVO> selectPager(PagerDTO pagerDTO);
}
