package com.zhq.permission.controller;

import com.zhq.permission.common.pojo.vo.UserVO;
import com.zhq.permission.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenghongquan
 * @create 2022/8/22 14:24
 * @desc 用户
 **/
@RestController
@RequestMapping("user")
@Api(value = "用户管理", tags = "用户管理-api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户")
    public Boolean addUser(@RequestBody UserVO vo){
        return userService.addUser(vo);
    }
}
