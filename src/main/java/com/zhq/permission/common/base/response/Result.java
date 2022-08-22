package com.zhq.permission.common.base.response;

import com.zhq.permission.common.utils.LanguageMsgUtils;
import com.zhq.permission.common.utils.ResultUtils;
import lombok.Data;

import java.util.Date;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:56
 * @desc 返回结果
 **/
@Data
public class Result {

    private int code;

    private String msg;

    private String path;

    private Date dateTime;

    private Object data = new Object();

    private Boolean success = false;

    public Result() {

    }

    public Result(String msg, String path) {
        this(ResultUtils.SUCCESS_CODE, msg, path, null);
    }

    public Result(BaseException ex, String path) {
        this(ex.getError().getCode(), LanguageMsgUtils.getErrorMsg(ex) == null ?
                ex.getError().getMsg() : LanguageMsgUtils.getErrorMsg(ex), path, ex.getData());
    }

    public Result(int code, String msg, String path, Object data) {
        this.code = code;
        this.msg = data == null ?
                msg : (msg + ":" + data.toString());
        this.path = path;
        this.dateTime = new Date();
        this.data = null;
    }
}
