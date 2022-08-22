package com.example.demo.rule;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 规则模板
 * @date 2022-08-01 11:42
 */
public abstract class AbstractRule implements BaseRule {

    protected <T> T convert(RuleData data) {
        return (T) data;
    }

    @Override
    public boolean execute(RuleData dto) {
        return executeRule(convert(dto));
    }

    protected <T> boolean executeRule(T t) {
        return true;
    }
}
