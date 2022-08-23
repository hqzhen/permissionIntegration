package com.zhq.permission.common.security;

import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
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
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
       /* SysResult result = new SysResult().setStatus(401).setMsg("用户认证失败请查询登录");
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);*/
        throw PermissionErrorCode.AUTHENTICATION_FAILED.ex();
    }
}