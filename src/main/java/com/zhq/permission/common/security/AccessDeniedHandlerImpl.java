package com.zhq.permission.common.security;

import com.alibaba.fastjson.JSON;
import com.zhq.permission.common.exception.errorcode.PermissionErrorCode;
import com.zhq.permission.common.utils.ResultUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenghongquan
 * @create 2022/8/23 11:29
 * @desc 授权失败处理器
 **/
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultUtils.authFail(PermissionErrorCode.USER_FORBIDDEN,httpServletRequest.getRequestURI())));
    }

}
