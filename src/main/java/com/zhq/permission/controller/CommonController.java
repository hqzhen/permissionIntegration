package com.zhq.permission.controller;

import com.zhq.permission.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author zhq
 * @create 2022/9/2 20:33
 * @desc 公共接口
 **/
@RestController
@RequestMapping("/common")
@Api(value = "公共接口", tags = "公共接口")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping("getEnum/{enumName}")
    @ApiOperation("获取后端枚举值信息")
    public List<Map<String, Object>> getEnumByEnumName(@PathVariable(value = "enumName") String enumName) {
        return commonService.getEnumByEnumName(enumName);
    }

    /**
     * 下载系统静态资源文件
     *
     * @param resourcesPath 全路径 例如 static/test.xlsx
     * @param response      回参
     */
    @GetMapping("/downloadStaticFile")
    @ApiOperation("下载系统静态资源文件")
    public void downloadStaticFile(@RequestParam String resourcesPath,
                                   HttpServletResponse response) {
        commonService.downloadStaticFile(resourcesPath, response);
    }


}
