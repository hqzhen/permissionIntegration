package com.zhq.permission.common.config;

import com.zhq.permission.common.base.response.Result;
import com.zhq.permission.common.utils.ResultUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghongquan
 * @create 2022/8/22 15:41
 * @desc 统一返回格式
 **/
@Configuration
public class ReturnValueConfig implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        this.decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                ReturnValueHandler decorator = new ReturnValueHandler(
                        (RequestResponseBodyMethodProcessor) handler);
                int index = handlers.indexOf(handler);
                handlers.set(index, decorator);
                break;
            }
        }
    }

    class ReturnValueHandler implements HandlerMethodReturnValueHandler {

        private RequestResponseBodyMethodProcessor target;

        public ReturnValueHandler(RequestResponseBodyMethodProcessor target) {
            this.target = target;
        }


        /**
         * 是否需要 走
         */
        @Override
        public boolean supportsReturnType(MethodParameter methodParameter) {
            return true;
        }


        /**
         * 重写修改 全局响应标准
         *
         * @param data
         * @param methodParameter
         * @param modelAndViewContainer
         * @param nativeWebRequest
         * @throws Exception
         */
        @Override
        public void handleReturnValue(Object data, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
            HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
            Result result = ResultUtils.success(data);
            result.setPath(request == null ? nativeWebRequest.getContextPath() : request.getRequestURI());
            target.handleReturnValue(result, methodParameter, modelAndViewContainer, nativeWebRequest);
        }
    }
}
