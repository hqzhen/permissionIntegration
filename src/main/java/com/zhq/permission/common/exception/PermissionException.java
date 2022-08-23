package com.zhq.permission.common.exception;

import com.zhq.permission.common.base.response.BaseException;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;

/**
 * @author zhenghongquan
 * @create 2022/8/23 10:59
 * @desc
 **/
public class PermissionException extends BaseException {

    public PermissionException(PermissionErrorCode errorCode, Object data) {
        super(errorCode, data);
    }

    public PermissionException(PermissionErrorCode errorCode) {
        super(errorCode, null);
    }
}