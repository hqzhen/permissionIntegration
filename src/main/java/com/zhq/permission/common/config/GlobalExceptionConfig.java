package com.zhq.permission.common.config;

import com.zhq.permission.common.base.response.BusinessErrorCode;
import com.zhq.permission.common.base.response.BusinessException;
import com.zhq.permission.common.base.response.Result;
import com.zhq.permission.common.utils.RequestBodyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author zhenghongquan
 * @create 2022/8/22 17:19
 * @desc 全局异常配置
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionConfig {

    /**
     * 参数校验异常
     *
     * @param ex 校验异常
     * @return ErrorResponse
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result validExceptionHandler(Exception ex, HttpServletRequest request) {
        String errMsg = null;
        if (ex instanceof BindException) {
            errMsg = ((BindException) ex).getBindingResult().getFieldErrors()
                    .stream().map(error -> error.getField() + ":" + error.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        } else if (ex instanceof MethodArgumentNotValidException) {
            errMsg = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors()
                    .stream().map(error -> error.getField() + ":" + error.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        } else if (ex instanceof ConstraintViolationException) {
            errMsg = ((ConstraintViolationException) ex).getConstraintViolations().stream()
                    .map(error -> error.getPropertyPath() + ":" + error.getMessage()).collect(Collectors.joining(","));
        }
        log.error(errMsg);
        return new Result(new BusinessException(BusinessErrorCode.BAD_REQUEST, errMsg), request.getRequestURI());
    }

    /**
     * http入参序列化错误
     *
     * @param ex 异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.error("http入参序列化错误：url:{}，普通参数：{},body参数：{}错误信息：{}",
                request.getRequestURI(), request.getQueryString(), RequestBodyUtils.getParameter(request), ex.getMessage());
        return new Result(new BusinessException(BusinessErrorCode.INPUT_PARAMETER_FORMAT_ERROR), request.getRequestURI());
    }
}