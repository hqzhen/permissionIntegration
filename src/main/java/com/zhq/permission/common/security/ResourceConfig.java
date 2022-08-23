package com.zhq.permission.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author zhenghongquan
 * @create 2022/8/23 11:45
 * @desc 启动方法上的权限控制,需要授权才可访问的方法上添加@PreAuthorize等相关注解
 **/
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //1.关闭csrf跨域攻击
        http.csrf().disable();
        //2.放行相关请求
        http.authorizeRequests()
                .antMatchers("/resource/**","/permission/user/**")
                .authenticated()
                .anyRequest().permitAll();
        //配置异常处理器
        http.exceptionHandling()
                //配置认证失败及授权失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}