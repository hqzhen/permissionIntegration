package com.zhq.permission.controller;

import com.zhq.permission.common.components.easyexcel.annotation.ExcelParam;
import com.zhq.permission.common.components.easyexcel.annotation.ExcelResponse;
import com.zhq.permission.common.components.easyexcel.validator.ReadRows;
import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidErrors;
import com.zhq.permission.common.components.easyexcel.validator.errors.ExcelValidObjectError;
import com.zhq.permission.common.pojo.dto.DemoData;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhq
 * @create 2022/9/2 21:59
 * @desc
 **/
@RestController
@RequestMapping("/excel")
@Api(value = "excel导入demo", tags = "excel导入demo")
public class EasyExcelController {

    @PostMapping("/list/obj")
    public List<DemoData> listObj(@ExcelParam @Validated List<DemoData> list, ExcelValidErrors errors) {
        if (errors.hasErrors()) {
            String messages = errors.getAllErrors().stream().map(ExcelValidObjectError::getMessage).collect(Collectors.joining(" | "));
            throw new RuntimeException("发现异常:" + messages);
        }
        return list;
    }

    @PostMapping("/list/rows")
    public ReadRows<DemoData> readRows(@ExcelParam(value = "file") @Validated ReadRows<DemoData> readRows) {
        return readRows;
    }

    @ExcelResponse(fileName = "测试下载excel")
    @GetMapping("/list/download")
    public List<DemoData> downloadList() {
        return Arrays.asList(new DemoData(1, "hello", new Date()), new DemoData(2, "excel", new Date()));
    }

}
