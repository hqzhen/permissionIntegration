package com.zhq.permission.common.utils;

import com.zhq.permission.common.base.response.Result;
import org.springframework.http.HttpStatus;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:01
 * @desc
 **/
public class ResultUtils {

    public final static Integer SUCCESS_CODE = 100000;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        String msg = LanguageMsgUtils.getErrorMsg(String.valueOf(SUCCESS_CODE));
        result.setMsg(msg == null ? HttpStatus.OK.getReasonPhrase() : msg);
        result.setData(data);
        return result;
    }
}
