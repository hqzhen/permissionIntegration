package com.zhq.permission.common.utils;

import com.zhq.permission.common.base.response.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:10
 * @desc 多语言翻译工具
 **/
@Slf4j
@Component
public class LanguageMsgUtils {

    private static MessageSource messageSource;

    public LanguageMsgUtils(MessageSource messageSource){
        LanguageMsgUtils.messageSource=messageSource;
    }

    /**
     * 翻译错误提示
     */
    public static String getErrorMsg(BaseException ex) {
        try {
            return messageSource.getMessage(String.valueOf(ex.getError().getCode()), null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            log.error(" 翻译错误:{}",e.getMessage(),e);
            return null;
        }
    }
    /**
     * 翻译错误提示
     */
    public static String getErrorMsg(String errorCode){
        try {
            return messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            log.error(" 翻译错误:{}",e.getMessage(),e);
            return null;
        }
    }
}
