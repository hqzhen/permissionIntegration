package com.zhq.permission.common.utils;

import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @author zhenghongquan
 * @create 2022/8/22 13:41
 * @desc 手工触发参数检验工具
 **/
public class ValidatorUtils {


    private static Validator globalValidator;

    protected ValidatorUtils(Validator globalValidator) {
        ValidatorUtils.globalValidator = globalValidator;
    }

    /**
     * 手动触发分组检验
     *
     * @param object 要检验的bean 提示:自定义提示
     * @param groups 要检验的分组
     * @param <T>    泛型
     * @return <T> Set<ConstraintViolation<T>>
     */
    public static <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = groups == null ?
                globalValidator.validate(object, Default.class) : globalValidator.validate(object, groups);
        if (!validate.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> validateMsg : validate) {
                message.append(validateMsg.getMessage())
                        .append(";");
            }
            Assert.isTrue(validate.isEmpty(), message.toString());
        }
        return validate;
    }

    /**
     * 手动触发分组检验
     *
     * @param object 要检验的bean  提示:字段名+框架自带提示
     * @param groups 要检验的分组
     * @param <T>    泛型
     * @return <T> Set<ConstraintViolation<T>>
     */
    public static <T> Set<ConstraintViolation<T>> validateAll(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = groups == null ?
                globalValidator.validate(object, Default.class) : globalValidator.validate(object, groups);
        if (!validate.isEmpty()) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> validateMsg : validate) {
                message.append(validateMsg.getPropertyPath())
                        .append(":")
                        .append(validateMsg.getMessage())
                        .append(";");
            }
            Assert.isTrue(validate.isEmpty(), message.toString());
        }
        return validate;
    }

}
