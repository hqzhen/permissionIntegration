package com.zhq.permission.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * @author zhenghongquan
 * @create 2022/8/25 9:20
 * @desc 覆写授权接口
 **/
@RestController
@RequestMapping("/oauth")
@Api(value = "OAuth接口", tags = "OAuth接口")
public class OauthController {

    //令牌请求的端点
    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private CheckTokenEndpoint checkTokenEndpoint;

    //自定义异常翻译器，针对用户名、密码异常，授权类型不支持的异常进行处理
    //private OAuthServerWebResponseExceptionTranslator translate;

    /**
     * 重写/oauth/token这个默认接口，返回的数据格式统一
     */
    @PostMapping(value = "/token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "认证类型", required = true, example = "password", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "client_id", value = "客户端标识", required = true, example = "gateway-client", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "client_secret", value = "客户端密钥", required = true,example = "123456", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true,example = "zhq", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,example = "123456", dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "生成token")
    public OAuth2AccessToken postAccessToken(Principal principal, @RequestParam
            Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        return tokenEndpoint.postAccessToken(principal, parameters).getBody();
    }

    /**
     * 重写/oauth/check_token这个默认接口，用于校验令牌，返回的数据格式统一
     */
    @PostMapping(value = "/check_token")
    @ApiOperation(value = "解析token")
    public Map<String, ?> checkToken(@RequestParam("token") String value) {
        return checkTokenEndpoint.checkToken(value);
    }
}
