package com.mood;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-12-28 下午2:38
 */
public interface RestStatus {

    /**
     * the status codes of per restful request.
     *
     * @return 20xxx if succeed, 40xxx if client error, 50xxx if server side crash.
     */
    int code();

    /**
     * @return status enum name
     */
    String name();

    /**
     * @return message summary
     */
    String message();

}
