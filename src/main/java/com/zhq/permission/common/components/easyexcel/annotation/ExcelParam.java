package com.zhq.permission.common.components.easyexcel.annotation;

import java.lang.annotation.*;

/**
 * @author zhq
 * @create 2022/9/2 21:28
 * @desc
 **/
@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelParam {


    /**
     * 字段名称
     *
     * @return String
     */
    String value() default "file";

    /**
     * 是否必须
     *
     * @return boolean
     */
    boolean required() default true;
}
