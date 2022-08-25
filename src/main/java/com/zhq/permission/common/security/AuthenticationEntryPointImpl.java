package com.zhq.permission.common.security;

import com.alibaba.fastjson.JSON;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import com.zhq.permission.common.utils.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenghongquan
 * @create 2022/8/23 11:39
 * @desc 自定义认证失败异常处理器
 **/
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.AUTHENTICATION_FAILED,request.getRequestURI())));
    }
}