package com.zhq.permission.common.components.easyexcel.validator;

import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidErrors;

/**
 * @author zhq
 * @create 2022/9/2 21:46
 * @desc 异常校验
 **/
public class ExcelValidException extends RuntimeException {

    private ExcelValidErrors errors;

    public ExcelValidException(String message, ExcelValidErrors errors) {
        super(message);
        this.errors = errors;
    }

    public ExcelValidErrors getErrors() {
        return errors;
    }

}
