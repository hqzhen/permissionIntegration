package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zhenghongquan
 * @Program: demo
 * @Description:
 * @date 2022-07-11 09:39
 */
public enum TestEnum {
    SallType(0, "销售平台类型"),
    ImportType(1, "导入类型"),
    BSCType(2, "共享仓类型"),
    WINITType(3, "墨尔本仓类型"),
    FPXType(4, "递四方仓类型"),
    CBType(5, "巴西仓类型"),
    JDType(6, "京东仓类型"),
    IMLType(7, "艾姆勒仓类型"),
    GcType(8, "谷仓类型"),
    TmType(9, "天马仓类型"),
    JoyType(10, "全和悦仓类型"),
    HxType(11,"海星仓类型"),
    ;

    public Integer value;

    public String desc;

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    TestEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
