package com.zhq.permission.common.utils;

import com.zhq.permission.common.base.response.Result;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:01
 * @desc
 **/
public class ResultUtils {

    public final static Integer SUCCESS_CODE = 100000;

    public static Result success(Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(SUCCESS_CODE);
        String msg = LanguageMsgUtils.getErrorMsg(String.valueOf(SUCCESS_CODE));
        result.setMsg(msg == null ? HttpStatus.OK.getReasonPhrase() : msg);
        result.setData(data);
        result.setDateTime(new Date());
        return result;
    }

    public static Result authFail(PermissionErrorCode permissionCode) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(permissionCode.getCode());
        String msg = LanguageMsgUtils.getErrorMsg(String.valueOf(permissionCode.getCode()));
        result.setMsg(msg == null ? permissionCode.getMsg() : msg);
        return result;
    }
}
