package com.zhq.permission.common.base.response;

import lombok.Getter;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:13
 * @desc 接口异常回参基础异常类
 **/
@Getter
public abstract class BaseException extends RuntimeException {

    private BaseErrorCode error;

    private Object data;

    public BaseException(BaseErrorCode error, Object data) {
        super(error.getMsg());
        this.error = error;
        this.data = data;
    }

    protected BaseException(BaseErrorCode error, Object data, Throwable cause) {
        super(error.getMsg(), cause);
        this.error = error;
        this.data = data;
    }
}
