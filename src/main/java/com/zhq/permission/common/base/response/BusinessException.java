package com.zhq.permission.common.base.response;

/**
 * @author zhenghongquan
 * @create 2022/8/22 17:16
 * @desc 业务异常
 **/
public class BusinessException extends BaseException {

    public BusinessException(BusinessErrorCode errorCode, Object data) {
        super(errorCode, data);
    }

    public BusinessException(BusinessErrorCode errorCode) {
        super(errorCode, null);
    }
}
