package com.zhq.permission.common.security;

import com.alibaba.fastjson.JSON;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import com.zhq.permission.common.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenghongquan
 * @create 2022/8/25 14:35
 * @desc
 **/
@Slf4j
@Component
public class TokenExceptionEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.error("token异常",e);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse
                .getWriter()
                .write(JSON.toJSONString(
                        ResultUtils.authFail(PermissionErrorCode.INVALID_TOKEN,
                                httpServletRequest.getRequestURI(),e.getMessage())));
    }
}
