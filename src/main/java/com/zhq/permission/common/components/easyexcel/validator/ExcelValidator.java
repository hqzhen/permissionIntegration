package com.zhq.permission.common.components.easyexcel.validator;

import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidErrors;

/**
 * @author zhq
 * @create 2022/9/2 21:47
 * @desc 数据校验
 **/
public interface ExcelValidator<T> {

    /**
     * 校验
     *
     * @param readRows 读取的行信息
     * @return
     */
    ExcelValidErrors validate(ReadRows<T> readRows);

}
