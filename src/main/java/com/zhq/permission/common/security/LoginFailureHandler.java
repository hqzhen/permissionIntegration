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
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter writer = response.getWriter();
        String errorMsg = "";
        if (exception instanceof BadCredentialsException) {
            errorMsg = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.AUTHENTICATION_FAILED));
        } else if (exception instanceof UsernameNotFoundException) {
            errorMsg = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.USER_DOES_NOT_EXIST));
        }  else {
            log.error("登入未知异常:", exception);
            errorMsg = JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.AUTHENTICATION_FAILED));
        }
        writer.write(errorMsg);
    }
}
