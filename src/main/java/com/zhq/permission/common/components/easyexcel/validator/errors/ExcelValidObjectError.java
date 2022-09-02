package com.zhq.permission.common.components.easyexcel.validator.errors;

/**
 * @author zhq
 * @create 2022/9/2 21:54
 * @desc
 **/
public interface ExcelValidObjectError {

    /**
     * 获取行号，从 1 开始
     *
     * @return
     */
    Integer getRow();

    /**
     * 获取错误消息
     *
     * @return
     */
    String getMessage();
}
