package com.mood.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.mood.BaseEntity;
import lombok.Data;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-11-09 下午3:25
 */
@Data
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "id", type = MySqlTypeConstant.VARCHAR, length = 32, isKey = true)
    private String id;

    /**
     * 用户名
     */
    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String password;

    /**
     * 密码
     */
    @Column(name = "test", type = MySqlTypeConstant.TEXT)
    private String test;


}
