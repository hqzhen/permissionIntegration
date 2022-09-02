package com.zhq.permission.common.components.easyexcel.annotation;

import java.lang.annotation.*;

/**
 * @author zhq
 * @create 2022/9/2 21:31
 * @desc
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResponse {

    String fileName() default "default";

    String sheetName() default "Sheet1";

}
