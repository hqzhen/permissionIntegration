package com.zhq.permission.common.components.easyexcel.validator.errors;

/**
 * @author zhq
 * @create 2022/9/2 21:53
 * @desc
 **/
public interface ExcelValidFieldError extends ExcelValidObjectError {


    /**
     * 获取列，从 1 开始
     *
     * @return
     */
    Integer getColumn();
}
