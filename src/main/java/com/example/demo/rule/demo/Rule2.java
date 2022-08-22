package com.example.demo.rule.demo;


import com.example.demo.rule.AbstractRule;
import com.example.demo.rule.RuleData;
import com.example.demo.rule.RuleKey;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 规则2
 * @date 2022-08-01 11:59
 */
@Slf4j
public class Rule2 extends AbstractRule {

    @Override
    protected <T> T convert(RuleData ruleData) {
        Rule2Data rule2Data = (Rule2Data) ruleData.getBusinessMapData().get(RuleKey.RULE2_KEY);;
        return (T) rule2Data;
    }


    @Override
    protected <T> boolean executeRule(T t) {
        System.out.println("执行【规则2】!");
        Rule2Data rule2Data = (Rule2Data) t;
        if (rule2Data.getLength()>10) {
            return true;
        }else if(rule2Data.getWidth()>20){
            return true;
        }
        return false;
    }
}
