package com.zhq.permission.common.base.response;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:15
 * @desc 接口异常回参错误码
 **/
public interface BaseErrorCode {

    /**
     * 获取错误码
     *
     * @return int
     */
    int getCode();

    /**
     * 获取错误提示
     *
     * @return String
     */
    String getMsg();

    /**
     * 带参数异常
     * @param data 参数
     * @return BaseException
     */
    BaseException ex(Object data);

    /**
     * 不带参数异常
     * @return BaseException
     */
    BaseException ex();
}
