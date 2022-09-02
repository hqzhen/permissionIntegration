package com.zhq.permission.common.components.easyexcel.resolver;

import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidErrors;
import org.springframework.core.MethodParameter;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zhq
 * @create 2022/9/2 21:43
 * @desc
 **/
public class ExcelValidErrorsResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == ExcelValidErrors.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ModelMap model = mavContainer.getModel();
        return model.getAttribute(BindingResult.MODEL_KEY_PREFIX + "excel");
    }
}
