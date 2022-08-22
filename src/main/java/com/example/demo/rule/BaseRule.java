package com.example.demo.rule;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 规则抽象
 * @date 2022-08-01 11:39
 */
public interface BaseRule {
    /**
     *  执行
     * @param data 业务元数据
     * @return boolean
     */
    boolean execute(RuleData data);
}
