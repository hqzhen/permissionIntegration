package com.zhq.permission.common.utils;

import com.zhq.permission.common.base.response.BaseException;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:22
 * @desc 结果返回断言工具
 **/
public interface ResultAssertUtils {
    /**
     * 如果不为空，则抛出异常
     * @param obj 判断条件
     * @param ex 抛出异常
     */
    static void isNull(Object obj, BaseException ex) {
        if (obj != null) {
            throw ex;
        }
    }

    /**
     * 如果为空，则抛出异常
     * @param obj 判断条件
     * @param ex 抛出异常
     */
    static void isNotNull(Object obj, BaseException ex) {
        if (obj == null) {
            throw ex;
        }
    }

    /**
     * 如果不为true，则抛出异常
     * @param bl 判断条件
     * @param ex 抛出异常
     */
    static void isTrue(boolean bl, BaseException ex) {
        if (!bl) {
            throw ex;
        }
    }
}
