package com.mood.user.vo;

import com.mood.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-11-09 下午3:25
 */
@Data
public class UserVO extends BaseEntity {

    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
