package com.example.demo.rule.demo;


import com.example.demo.rule.AbstractRule;
import com.example.demo.rule.RuleData;
import com.example.demo.rule.RuleKey;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description: 规则1
 * @date 2022-08-01 11:54
 */
@Slf4j
public class Rule1 extends AbstractRule {

    @Override
    public boolean execute(RuleData ruleData) {
        log.info("开始调用【规则1】");
        String data = (String) ruleData.getBusinessMapData().get(RuleKey.RULE1_KEY);
        String ruleRequirements = "我是规则1";
        if (data.equals(ruleRequirements)) {
            return true;
        }
        return false;
    }
}
