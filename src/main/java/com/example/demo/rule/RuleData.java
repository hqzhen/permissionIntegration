package com.example.demo.rule;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 业务元数据
 * @date 2022-08-01 11:37
 */
@Data
public class RuleData {
    /**
     * 业务数据
     */
    private Map<String, Object> businessMapData = new HashMap<>();
}
