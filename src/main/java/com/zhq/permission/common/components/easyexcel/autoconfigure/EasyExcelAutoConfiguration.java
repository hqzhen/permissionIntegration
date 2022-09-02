package com.zhq.permission.common.components.easyexcel.autoconfigure;

import com.zhq.permission.common.components.easyexcel.handler.ExcelResponseHandler;
import com.zhq.permission.common.components.easyexcel.resolver.ExcelParamResolver;
import com.zhq.permission.common.components.easyexcel.resolver.ExcelValidErrorsResolver;
import com.zhq.permission.common.components.easyexcel.validator.ExcelValidator;
import com.zhq.permission.common.components.easyexcel.validator.SpringValidatorExcelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhq
 * @create 2022/9/2 21:33
 * @desc
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class EasyExcelAutoConfiguration {

    @Bean
    @ConditionalOnBean(Validator.class)
    @ConditionalOnProperty(prefix = "easyexcel.validator.default", name = "enable", havingValue = "true", matchIfMissing = true)
    public ExcelValidator<Object> defaultExcelValidator(Validator validator) {
        return new SpringValidatorExcelValidator(validator);
    }

    @Bean
    public ExcelParamResolver excelDataResolver() {
        return new ExcelParamResolver();
    }

    /**
     * 设置解析器，保证自定义解析器优先级最高
     *
     * @param adapter
     */
    @Autowired
    public void setArgumentResolvers(RequestMappingHandlerAdapter adapter) {
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>();
        argumentResolvers.add(0, excelDataResolver());
        argumentResolvers.add(0, new ExcelValidErrorsResolver());
        argumentResolvers.addAll(adapter.getArgumentResolvers());
        adapter.setArgumentResolvers(argumentResolvers);
    }

    /**
     * 设置处理器，保证自定义处理器优先级最高
     *
     * @param adapter
     */
    @Autowired
    public void setReturnValueHandlers(RequestMappingHandlerAdapter adapter) {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList<>();
        returnValueHandlers.add(0, new ExcelResponseHandler());
        returnValueHandlers.addAll(adapter.getReturnValueHandlers());
        adapter.setReturnValueHandlers(returnValueHandlers);
    }
}
