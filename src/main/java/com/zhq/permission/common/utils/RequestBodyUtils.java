package com.zhq.permission.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

/**
 * @author zhenghongquan
 * @create 2022/8/22 17:27
 * @desc requestbody工具类
 **/
public class RequestBodyUtils {

    /**
     * 获取body参数
     * @param request 请求
     * @return String
     */
    public static String getParameter(HttpServletRequest request){
        String parameter="";
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
            parameter= StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
        }
        return parameter;
    }
}
