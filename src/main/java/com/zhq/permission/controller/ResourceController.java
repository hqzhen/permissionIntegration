package com.zhq.permission.controller;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhenghongquan
 * @create 2022/8/23 13:41
 * @desc 测试权限
 **/
@RestController
@RequestMapping("/resource")
@Api(value = "测试权限", tags = "测试权限-api")
public class ResourceController {

    /**
     * 查询资源
     * @return
     */
    @PreAuthorize("hasAuthority('system:test:list')")
    @GetMapping
    public String doSelect(){
        return "Select Resource ok";
    }
    /**
     * 创建资源
     * @return
     */
    @PreAuthorize("hasAuthority('system:test:list')")
    @PostMapping
    public String doCreate(){
        return "Create Resource OK";
    }
    /**
     * 修改资源
     * @return
     */
    @PreAuthorize("hasAuthority('system:test:list')")
    @PutMapping
    public String doUpdate(){
        return "Update Resource OK";
    }
    /**
     * 删除资源
     * @return
     */
    @DeleteMapping
    public String doDelete(){
        return "Delete resource ok";
    }
}
