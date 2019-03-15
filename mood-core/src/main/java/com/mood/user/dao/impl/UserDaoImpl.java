package com.mood.user.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mood.IdGen;
import com.mood.Pager;
import com.mood.PagerDTO;
import com.mood.user.dao.UserDao;
import com.mood.user.dao.mapper.UserMapper;
import com.mood.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-10-31 下午2:38
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    private RedisUtil redisUtil;

    @Override
    public User insert(User user) {
        user.setId(IdGen.uuid());
        if (userMapper.insert(user) > 0) {
            return user;
        }
        return null;
    }

    @Override
    public User update(User user) {
        if (userMapper.updateByPrimaryKey(user) > 0) {
            return user;
        }
        return null;
    }

    @Override
    public Boolean deleteById(String id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public User selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectList(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (user != null) {
            //拼接条件
            Object username = user.getUsername();
            if (username != null) {
                criteria.andEqualTo("username", username.toString());
            }
        }
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @Override
    public Pager<User> selectPager(PagerDTO pagerDTO) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        //查询条件
        JSONObject param = pagerDTO.getParams();
        if (param != null) {
            //拼接条件
        }
        User user = (User) pagerDTO.getT();
        if (param != null) {
            //拼接条件
        }
        String orderBy = pagerDTO.getOrderBy();
        if (orderBy != null) {
            example.setOrderByClause(orderBy);
        }
        //处理分页
        PageHelper.startPage(pagerDTO.getPageIndex().intValue(), pagerDTO.getPageSize().intValue());
        List<User> result = userMapper.selectByExample(example);
        //组装返回数据
        PageInfo pageInfo = new PageInfo(result);
        return new Pager(new Long(pageInfo.getPages()), new Long(pageInfo.getPageSize()), pageInfo.getTotal(), pageInfo.getList());
    }
}
