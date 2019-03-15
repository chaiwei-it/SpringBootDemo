package com.mood;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-12-28 下午2:38
 */
public class ResultVO<T> implements Serializable {


    public final static ResultVO EMPTY = new ResultVO(new HashMap<>());
    private String message;
    private Integer code;
    private T body;

    public static ResultVO fatal(RestStatus status) {
        return error(status.message(), status.code());
    }

    public ResultVO() {
    }

    public ResultVO(String message, Integer code, T body) {
        this.message = message;
        this.code = code;
        this.body = body;
    }


    public ResultVO(T body) {
        this.body = body;
        message = "";
        code = 0;
    }

    public static ResultVO error() {
        return new ResultVO<>("执行失败", 100, null);
    }

    public static ResultVO error(RestStatus restStatus) {
        return new ResultVO<>(restStatus.message(), restStatus.code(), null);
    }

    public static ResultVO error(String message, Integer code) {
        return new ResultVO<>(message, code, null);
    }

    public static ResultVO error(ErrorCode errorCode) {
        return new ResultVO<>(errorCode.getMessage(), errorCode.getCode(), null);
    }

    public static ResultVO success() {
        Map success = new HashMap();
        success.put("success", true);
        return new ResultVO<>("", 0, success);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
