package com.mood.user.service.impl;

import com.mood.Pager;
import com.mood.PagerDTO;
import com.mood.copy.OrikaMapper;
import com.mood.user.dao.UserDao;
import com.mood.user.dto.UserDTO;
import com.mood.entity.User;
import com.mood.user.service.UserService;
import com.mood.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2019-03-14 11:01 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 插入
     *
     * @param userInsertDTO
     * @return
     */
    @Override
    public UserVO insert(UserDTO userInsertDTO) {
        User user = OrikaMapper.map(userInsertDTO, User.class);
        userDao.insert(user);
        UserVO userInsertVO = OrikaMapper.map(user, UserVO.class);
        return userInsertVO;
    }

    /**
     * 修改
     *
     * @param userUpdateDTO
     * @return
     */
    @Override
    public UserVO update(UserDTO userUpdateDTO) {
        User user = OrikaMapper.map(userUpdateDTO, User.class);
        userDao.update(user);
        UserVO userUpdateVO = OrikaMapper.map(user, UserVO.class);
        return userUpdateVO;
    }

    /**
     * 删除详情
     *
     * @param id
     */
    @Override
    public Boolean deleteById(String id) {
        return userDao.deleteById(id);
    }

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    @Override
    public UserVO selectById(String id) {
        User user = userDao.selectById(id);
        if (user != null) {
            return OrikaMapper.map(user, UserVO.class);
        }
        return null;
    }

    /**
     * 获取列表
     *
     * @param userDTO
     * @return
     */
    @Override
    public List<UserVO> selectList(UserDTO userDTO) {
        User user = OrikaMapper.map(userDTO, User.class);
        List<User> userList = userDao.selectList(user);
        return OrikaMapper.mapList(userList, UserVO.class);
    }

    /**
     * 获取分页
     *
     * @param pagerDTO
     * @return
     */
    @Override
    public Pager<UserVO> selectPager(PagerDTO pagerDTO) {
        Pager<User> pager = userDao.selectPager(pagerDTO);
        return OrikaMapper.mapPager(pager, UserVO.class);
    }

}
