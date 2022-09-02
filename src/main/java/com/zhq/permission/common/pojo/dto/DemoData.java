package com.zhq.permission.common.pojo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.zhq.permission.common.validator.DemoDataValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author zhq
 * @create 2022/9/2 22:01
 * @desc
 **/
@Data
//@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@DemoDataValid
public class DemoData {

    @ExcelProperty(index = 0,value = "单号")
    @NotNull
    private Integer integer;

    @ExcelProperty(index = 1,value = "描述")
    private String string;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 2,value = "时间")
    private Date date;
}
