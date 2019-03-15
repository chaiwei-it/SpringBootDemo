package com.mood;

import lombok.Data;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-12-28 下午2:38
 */
@Data
public class ErrorCode {


    private Integer code;

    private String message;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
