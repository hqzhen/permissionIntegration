package com.zhq.permission.common.security;

import com.alibaba.fastjson.JSON;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import com.zhq.permission.common.utils.ResultUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zhenghongquan
 * @create 2022/8/24 17:42
 * @desc 登陆失败处理类
 **/
@Slf4j
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    @SneakyThrows
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter writer = response.getWriter();
        String msg = exception.getMessage();
        String result = "";
        String path = request.getRequestURI();
        if (exception instanceof BadCredentialsException) {
            result = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.AUTHENTICATION_FAILED, path,msg));
        } else if (exception instanceof UsernameNotFoundException) {
            result = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.USER_DOES_NOT_EXIST, path,msg));
        } else {
            log.error("登入未知异常:", exception);
            result = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.AUTHENTICATION_FAILED, path,msg));
        }
        writer.write(result);
    }
}
