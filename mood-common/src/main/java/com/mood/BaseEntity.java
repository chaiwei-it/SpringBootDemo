package com.mood;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

/**
 * 基础实体
 *
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
@Data
public class BaseEntity {

    /**
     * 创建时间-数据库字段
     */
    @Column(name = "create_time", type = MySqlTypeConstant.BIGINT, length = 13)
    private Long createTime;

    /**
     * 修改时间-数据库字段
     */
    @Column(name = "update_time", type = MySqlTypeConstant.BIGINT, length = 13)
    private Long updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_person", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String createPerson;

    /**
     * 修改人
     */
    @Column(name = "update_person", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String updatePerson;

    /**
     * 删除状态
     */
    @Column(name = "del_status", type = MySqlTypeConstant.INT, length = 1)
    private Integer delStatus;

}
