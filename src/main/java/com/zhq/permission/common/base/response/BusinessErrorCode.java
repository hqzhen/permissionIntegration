package com.zhq.permission.common.base.response;

import lombok.Getter;

/**
 * @author zhenghongquan
 * @create 2022/8/22 17:04
 * @desc 业务异常码
 **/
@Getter
public enum BusinessErrorCode implements BaseErrorCode {

    /**
     * 错误请求
     */
    BAD_REQUEST(100001, "错误请求"),
    /**
     * 服务器异常
     */
    INTERNAL_SERVER_ERROR(100002, "服务器异常"),
    /**
     * 超过API限制的访问次数
     */
    TOO_MANY_REQUESTS(100003, "超过API限制的访问次数"),
    /**
     * 超过API一天访问次数
     */
    DAILY_TOO_MANY_REQUESTS(100004, "超过API一天访问次数"),
    /**
     * 服务器繁忙
     */
    SERVER_IS_BUSY(100005, "服务器繁忙，请稍后再试"),
    /**
     * 未找到数据
     */
    DATA_NOT_FOUND(100006, "未找到数据"),
    /**
     * 入参格式错误
     */
    INPUT_PARAMETER_FORMAT_ERROR(100007, "入参格式错误"),

    /**
     * 远程访问超时
     */
    REMOTE_ACCESS_TIMEOUT(100008, "远程访问超时"),

    ;

    private final int code;


    private final String msg;

    BusinessErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public BaseException ex(Object data) {
        return new BusinessException(this, data);
    }

    @Override
    public BaseException ex() {
        return new BusinessException(this);
    }
}
