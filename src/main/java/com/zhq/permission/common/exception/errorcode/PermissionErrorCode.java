package com.zhq.permission.common.exception.errorcode;

import com.zhq.permission.common.base.response.BaseErrorCode;
import com.zhq.permission.common.base.response.BaseException;
import com.zhq.permission.common.exception.PermissionException;
import lombok.Getter;

/**
 * @author zhenghongquan
 * @Program: yh-api
 * @Description: 客户错误提示码
 * @date 2021-03-24 14:19
 */
@Getter
public enum PermissionErrorCode implements BaseErrorCode {
    /**
     * 用户未被授权
     */
    USER_UNAUTHORIZED(101001,  "未被授权"),
    /**
     * 用户权限不足
     */
    USER_FORBIDDEN(101002, "权限不足"),
    /**
     * 超过接口使用次数
     */
    EXCEEDED_API_USAGE_TIMES(101003, "超过接口使用次数"),
    /**
     * token已过期
     */
    TOKEN_HAS_EXPIRED(101004, "token已过期"),
    /**
     * token不支持
     */
    TOKEN_DOES_NOT_SUPPORT(101005,  "token不支持"),
    /**
     * token格式不对
     */
    BAD_Token_Format(101006,  "token格式不对"),
    /**
     * token签名不对
     */
    BAD_TOKEN_SIGNATURE(101007,  "token签名不对"),
    /**
     * token格式转换错误
     */
    TOKEN_FORMAT_CONVERSION_ERROR(101008,  "token格式转换错误"),
    /**
     * 无效token
     */
    INVALID_TOKEN(101009,  "无效token"),
    /**
     * 用户不存在
     */
    USER_DOES_NOT_EXIST(101010,  "用户不存在"),
    /**
     * 密码错误
     */
    WRONG_PASSWORD(101011, "密码错误"),
    /**
     * 认证失败
     */
    AUTHENTICATION_FAILED(101012, "认证失败"),
    /**
     * 用户被锁定或者未激活
     */
    USER_IS_LOCKED_OR_INACTIVE(101013,  "用户被锁定或者未激活"),
    ;


    private final int code;


    private final String msg;

    PermissionErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public BaseException ex(Object data) {
        return new PermissionException(this, data);
    }

    @Override
    public BaseException ex() {
        return new PermissionException(this);
    }
}
